package com.scalaprojects.cats.typeclasses.printable

import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class PrintableTest extends ScalaProjectsSpec {
  it("enables an application to define objects with String and Int members as printable") {
    import CatPrintable.catPrintable

    val cat = Cat("Felix", 10, "black")

    Printable.print(cat)

    Printable.format(cat) shouldBe "Felix is a 10 year-old black cat"

  }
}
