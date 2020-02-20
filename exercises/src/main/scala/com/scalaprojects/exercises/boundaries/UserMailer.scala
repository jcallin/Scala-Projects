package com.scalaprojects.exercises.boundaries

import com.typesafe.scalalogging.StrictLogging

object UserMailer extends StrictLogging {

  /** Bills a user */
  def bill(user: User)(implicit userDatabase: UserDatabase): Unit = {
    userDatabase.mailTo(user, "Give cash plz")
    logger.info(
      s"Billed user ${user.name} who had not paid since ${user.paidAt}"
    )
  }
}
