package com.scalaprojects.cats.typeclasses.printable

import cats.Eq
import cats.implicits._

final case class Cat(name: String, age: Int, color: String)

object Cat {
  implicit val catEq: Eq[Cat] = {
    Eq.instance[Cat] { (c1, c2) =>
      (c1.name === c2.name) &&
      (c1.color === c2.color) &&
      (c1.age === c2.age)
    }
  }
}
