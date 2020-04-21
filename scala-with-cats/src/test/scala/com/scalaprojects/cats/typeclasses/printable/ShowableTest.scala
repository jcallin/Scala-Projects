package com.scalaprojects.cats.typeclasses.printable

import cats.implicits._
import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class ShowableTest extends ScalaProjectsSpec {
  it("shows a cat") {
    import CatShowable.catShow

    val cat            = Cat("Felix", 10, "black")
    val stringifiedCat = "Felix is a 10 year-old black cat"

    cat.show shouldBe stringifiedCat
  }
}
