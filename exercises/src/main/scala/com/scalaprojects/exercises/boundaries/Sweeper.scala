package com.scalaprojects.exercises.boundaries

object Sweeper {
  def sweep(users: Seq[User])(implicit database: UserDatabase): Unit = {
    ExpiredUsers
      .forUsers(users)
      .foreach(user => UserMailer.bill(user))
  }
}
