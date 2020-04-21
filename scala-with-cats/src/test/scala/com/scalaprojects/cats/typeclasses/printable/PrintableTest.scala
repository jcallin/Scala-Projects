package com.scalaprojects.cats.typeclasses.printable

import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class PrintableTest extends ScalaProjectsSpec {
  val cat            = Cat("Felix", 10, "black")
  val stringifiedCat = "Felix is a 10 year-old black cat"

  it(
    "enables an application to define objects with String and Int members as printable"
  ) {
    import CatPrintable.catPrintable

    Printable.print(cat)

    Printable.format(cat) shouldBe stringifiedCat
  }
  it(
    "defines a syntax to call printable methods on values which have an implicit Printable defined"
  ) {
    import CatPrintable.catPrintable
    import PrintableSyntax._

    cat.format shouldBe stringifiedCat

  }
}
