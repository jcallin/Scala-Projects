package exercise

import java.net.URL

import com.typesafe.config.ConfigFactory
import exercise.database.Database
import org.apache.commons.csv.{CSVFormat, CSVParser}
import scalikejdbc._
import sttp.client3.{HttpURLConnectionBackend, _}

import scala.jdk.CollectionConverters._

case class Registration(
    fileNumber: String,
    businessName: String,
    active: Boolean,
    filingDate: String,
    updatedAt: String
)
case class Address(fileNumber: String, address: String, updatedAt: String)

object Exercise extends App {
  Database.createTable()
  val config = ConfigFactory.load()

  Class.forName("org.postgresql.Driver")
  ConnectionPool.singleton(
    "jdbc:postgresql:postgres",
    config.getString("postgres.user"),
    config.getString("postgres.password")
  )

  implicit val session = AutoSession

  val addressesCsv: Seq[Address] = downloadData("addresses")
    .map { case (date, v) => date -> CSVParser.parse(v, CSVFormat.DEFAULT.withHeader()) }
    .flatMap { case (date, records) =>
      records.getRecords.asScala.map { record =>
        Address(
          fileNumber = record.get("file_number"),
          address = record.get("address"),
          updatedAt = date
        )
      }
    }
    .toSeq

  addressesCsv foreach { address =>
    sql"insert into addresses (file_number, address, updated_at) values (${address.fileNumber}, ${address.address}, ${address.updatedAt})".update
      .apply()
  }

  val activeStates = Set("ACTIVE")

  val registrions: Seq[Registration] = downloadData("registrations")
    .map { case (date, v) => date -> CSVParser.parse(v, CSVFormat.DEFAULT.withHeader()) }
    .flatMap { case (date, records) =>
      records.getRecords.asScala.map { record =>
        Registration(
          fileNumber = record.get("file_number"),
          businessName = record.get("business_name"),
          active = if (activeStates.contains(record.get("status"))) { true }
          else { false },
          filingDate = record.get("filing_date"),
          updatedAt = date
        )
      }
    }
    .toSeq

  registrions foreach { reg =>
    sql"insert into registrations (file_number, name, active, filing_date, updated_at) values (${reg.fileNumber}, ${reg.businessName}, ${reg.active}, ${reg.filingDate}, ${reg.updatedAt})".update
      .apply()
  }

  def downloadData(key: String): Map[String, String] = {
    val DateRegex = "[0-9]{4}-[0-9]{2}-[0-9]{2}".r
    val backend   = HttpURLConnectionBackend()
    val urls      = ConfigFactory.load().getStringList(key).asScala.map(u => new URL(u))
    urls
      .map { u =>
        val request = basicRequest.get(uri"$u").send(backend)
        val r = request.body match {
          case Left(value)  => value
          case Right(value) => value
        }
        DateRegex.findFirstIn(u.toString).get -> r
      }
      .toSeq
      .toMap
  }
}
