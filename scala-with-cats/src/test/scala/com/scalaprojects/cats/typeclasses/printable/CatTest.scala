package com.scalaprojects.cats.typeclasses.printable

import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class CatTest extends ScalaProjectsSpec {
  val cat            = Cat("Felix", 10, "black")
  val stringifiedCat = "Felix is a 10 year-old black cat"

  describe("printable") {
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

  describe("showable") {
    it("shows a cat") {
      import cats.implicits._

      import CatShowable.catShow

      cat.show shouldBe stringifiedCat
    }
  }

  describe("equality") {
    val cat2 = Cat("Garfield", 20, "tabby")
    import cats.syntax.eq._

    it("compares 2 cats") {

      // broken due to scalatest dependency on scalactic which also gives an === implementation
      // cat === cat2 shouldBe false
      // use this instead
      CatsEqCheck.checkEqual(cat, cat2) shouldBe false
      cat =!= cat2 shouldBe true
    }

    it("compares 2 cat monads") {
      import cats.instances.option._

      CatsEqCheck.checkEqual(Option(cat), Option(cat2)) shouldBe false
      Option(cat) =!= Option(cat2) shouldBe true
    }
  }

}
