package com.scalaprojects.cats.typeclasses.json

object JsonInterface {
  def toJson[A](value: A)(implicit w: JsonWriter[A]): Json =
    w.write(value)
}

// An alternative way of providing functionality is extending the A class with .toJson functionality
object JsonSyntax {
  implicit class JsonWriterOps[A](value: A) {
    def toJson(implicit w: JsonWriter[A]): Json =
      w.write(value)
  }
}
