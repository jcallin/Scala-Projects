package com.scalaprojects.exercises.boundaries

import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class UserDatabaseTest extends ScalaProjectsSpec with UserDatabaseTestData {
  describe("When managing user mail") {
    it("should mail to a user") {
      database.mailTo(user1, "hi") shouldBe true
      database.getMailFor(user1) shouldBe List("hi")
    }
    it("should not mail to a non-existent user") {
      database.mailTo(nonUser, "to the void") shouldBe false
    }
    it("should return an empty inbox for a user not in the database") {
      database.getMailFor(nonUser) shouldBe List.empty
    }
  }

}
