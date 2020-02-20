package com.scalaprojects.cats.typeclasses

import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class JsonTest extends ScalaProjectsSpec {
  describe("the json write interface") {
    it("Provides a JSON serialization type class via an interface object") {
      import JsonWriterInstances._

      JsonInterface.toJson(Person("Dave", "dave@example.com"))
    }
    it("Provides a JSON serialization type class via interface syntax") {
      import JsonSyntax._
      import JsonWriterInstances._

      Person("Dave", "dave@example.com").toJson
    }
  }
}
