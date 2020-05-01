package com.scalaprojects.cats.typeclasses.printable

import cats.syntax.eq._
import cats.instances.option._

object CatsEqCheck {
  def checkEqual(c1: Cat, c2: Cat): Boolean = {
    c1 === c2
  }

  def checkEqual(c1: Option[Cat], c2: Option[Cat]): Boolean = {
    c1 === c2
  }

}
