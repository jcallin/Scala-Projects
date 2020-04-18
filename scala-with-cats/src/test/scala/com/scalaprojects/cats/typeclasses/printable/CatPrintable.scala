package com.scalaprojects.cats.typeclasses.printable

import PrintableInstances.{intPrintable, stringPrintable}

object CatPrintable {
  implicit val catPrintable: Printable[Cat] = (cat: Cat) => {
    val name = Printable.format(cat.name)
    val age = Printable.format(cat.age)
    val color = Printable.format(cat.color)
    s"$name is a $age year-old $color cat"
  }
}
