package com.scalaprojects.exercises.boundaries

import java.time.LocalDate

object ExpiredUsers {
  private val paymentExpiration = LocalDate.now().minusMonths(1).atTime(0, 0)

  /** Return all users who are active and who have not paid for over a month before today */
  def forUsers(users: Seq[User]): List[User] = {
    users.filter(user => user.active && user.paidAt.isBefore(paymentExpiration)).toList
  }
}
