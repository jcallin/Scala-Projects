package com.scalaprojects.cats.typeclasses.json

// The type class instances

final case class Person(name: String, email: String)

object JsonWriterInstances {
  implicit val stringWriter: JsonWriter[String] =
    new JsonWriter[String] {
      def write(value: String): Json = JsString(value)
    }
  implicit val personWriter: JsonWriter[Person] =
    new JsonWriter[Person] {
      def write(value: Person): Json =
        JsObject(Map("name" -> JsString(value.name), "email" -> JsString(value.email)))
    }

  /** Is able to generate any JsonWriter for Option[A] as long as you have a JsonWriter[A] in scope */
  implicit def optionWriter[A](implicit writer: JsonWriter[A]): JsonWriter[Option[A]] = {
    case Some(aValue) => writer.write(aValue)
    case None         => JsNull
  }

  // etc...
}

object JsonWriterInstancesSimplified {
  implicit val stringWriter: JsonWriter[String] =
    (value: String) => JsString(value)
  implicit val personWriter: JsonWriter[Person] =
    (value: Person) =>
      JsObject(Map("name" -> JsString(value.name), "email" -> JsString(value.email)))

  // etc...
}
