package middesk.database.schemas
// defines entity object and extractor
import java.time._
import scalikejdbc.{WrappedResultSet, _}

case class Member(id: Long, name: Option[String], createdAt: ZonedDateTime)
object Member extends SQLSyntaxSupport[Member] {
  override val tableName = "members"
  def apply(rs: WrappedResultSet): Member =
    new Member(rs.long("id"), rs.stringOpt("name"), rs.zonedDateTime("created_at"))
}
