package com.scalaprojects.cats.typeclasses.printable

object PrintableSyntax {

  /** Provides printable extension methods to attach to values
    *
    * @param value to become printable
    */
  implicit class PrintableMethods[A](value: A) {
    def format(implicit p: Printable[A]): String = {
      Printable.format(value)
    }
    def print(implicit p: Printable[A]): Unit = {
      Printable.print(value)
    }
  }
}
