package com.scalaprojects.cats.typeclasses.printable

trait Printable[A] {
  def format(a: A): String
}

object Printable {
  def format[A](value: A)(implicit p: Printable[A]): String = {
    p.format(value)
  }
  def print[A](value: A)(implicit p: Printable[A]): Unit = {
    println(value)
  }
}
