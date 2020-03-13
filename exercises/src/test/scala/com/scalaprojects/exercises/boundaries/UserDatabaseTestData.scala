package com.scalaprojects.exercises.boundaries

import java.time.{LocalDate, LocalDateTime}

trait UserDatabaseTestData {
  val someExpiredTime = LocalDate.now().minusMonths(2).atTime(0, 0)
  val someNonExpiredTime = LocalDate.now().minusDays(2).atTime(0, 0)
  val user1 = User(name = "alice", active = true, paidAt = someExpiredTime)
  val user2 = User(name = "charlie", active = true, paidAt = someNonExpiredTime)
  val user3 = User(name = "bob", active = false, paidAt = someExpiredTime)
  val user4 = User(name = "dave", active = false, paidAt = someNonExpiredTime)
  val nonUser = User("0man", active = false, paidAt = LocalDateTime.now)
  val users = List(user1, user2, user3, user4)
  implicit val database = new UserDatabase(users)
}
