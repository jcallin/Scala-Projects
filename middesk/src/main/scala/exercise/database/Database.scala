package exercise.database

import com.typesafe.config.ConfigFactory
import exercise.database.schemas.Member
import scalikejdbc._

object Database {
  val config = ConfigFactory.load()

  Class.forName("org.postgresql.Driver")
  ConnectionPool.singleton(
    "jdbc:postgresql:postgres",
    config.getString("postgres.user"),
    config.getString("postgres.password")
  )

  implicit val session = AutoSession

  def createTable(): Unit = {
    sql"""
      create table addresses (
        file_number varchar(64),
        address varchar(64),
        updated_at varchar(64)
      )
    """.execute.apply()

    sql"""
      create table registrations (
        file_number varchar(64),
        name varchar(64),
        active boolean,
        filing_date varchar(64),
        updated_at varchar(64)
      )
    """.execute.apply()

//    // insert initial data
//    Seq("Alice", "Bob", "Chris") foreach { name =>
//      sql"insert into members (name, created_at) values ($name, current_timestamp)".update.apply()
//    }

  }

  // for now, retrieves all data as Map value
  def entities: List[Map[String, Any]] = sql"select * from members".map(_.toMap).list.apply()

  def members: List[Member] = sql"select * from members".map(rs => Member(rs)).list.apply()

  def alice: Option[Member] =
    withSQL {
      val m    = Member.syntax("m")
      val name = "Alice"
      select.from(Member as m).where.eq(m.name, name)
    }.map(rs => Member(rs)).single.apply()
}
