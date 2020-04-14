package com.scalaprojects.cats.typeclasses.printable

object PrintableInstances {
  implicit val stringPrintable: Printable[String] = (s: String) => s
  implicit val intPrintable: Printable[Int] = (i: Int) => i.toString
}
