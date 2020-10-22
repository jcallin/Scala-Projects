package com.scalaprojects.exercises.boundaries

import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class SweeperTest extends ScalaProjectsSpec with UserDatabaseTestData {

  /** This is an example of an integration test. The Sweeper is the "imperative shell" to the program which contains external dependencies
    */
  describe("When running database sweeps") {

    Sweeper.sweep(database.users)

    it("should mail a list of active users whose subscriptions have expired") {
      database.getMailFor(user1) shouldBe List("Give cash plz")
      database.getMailFor(user3) shouldBe List.empty
    }
    it("should not mail inactive users") {
      database.getMailFor(user2) shouldBe List.empty
      database.getMailFor(user4) shouldBe List.empty
    }
  }
}
