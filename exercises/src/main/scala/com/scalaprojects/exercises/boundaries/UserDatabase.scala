package com.scalaprojects.exercises.boundaries

import com.typesafe.scalalogging.StrictLogging

class UserDatabase(val users: List[User] = List.empty) extends StrictLogging {
  private var inboxes: Map[User, List[String]] =
    users.map(user => user -> List.empty[String]).toMap

  /**
    * Mail a message to a user
    * @param user to mail to
    * @param message to mail, will be in user's inbox
    */
  def mailTo(user: User, message: String): Boolean = {
    if (!users.contains(user)) {
      logger.warn(s"No user ${user.name} exists to mail to")
      false
    } else {
      inboxes = inboxes.updatedWith(user)(emails =>
        Some(message :: emails.getOrElse(List.empty[String]))
      )
      true
    }
  }

  /** Get mail messages for a user */
  def getMailFor(user: User): List[String] = {
    inboxes.getOrElse(
      user, {
        logger.warn(s"No user ${user.name} exists to get mail for")
        List.empty
      }
    )
  }
}
