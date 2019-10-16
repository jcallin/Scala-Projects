package com.scalaprojects.exercises.boundaries

import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class ExpiredUsersTest extends ScalaProjectsSpec with UserDatabaseTestData {
  it("should return a list of expired users") {
    ExpiredUsers.forUsers(users) shouldBe List(user1)
  }
}
