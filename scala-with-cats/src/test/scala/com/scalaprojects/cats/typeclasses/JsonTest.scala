package com.scalaprojects.cats.typeclasses

import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class JsonTest extends ScalaProjectsSpec {
  describe("the json write interface provides a JSON serialization type class") {
    val simpleJsonString = """{"k1" = "v1"}"""
    val simpleJson = JsString(simpleJsonString)

    val simpleJsonPerson = Person("Dave", "dave@example.com")
    val simpleJsonPersonObject = JsObject(
      Map(
        "name" -> JsString("Dave"),
        "email" -> JsString("dave@example.com")
      )
    )

    it("via an interface object") {
      import JsonWriterInstances._

      JsonInterface.toJson(simpleJsonString) shouldBe simpleJson
      JsonInterface.toJson(simpleJsonPerson) shouldBe simpleJsonPersonObject
    }
    it("via interface syntax") {
      import JsonSyntax._
      import JsonWriterInstances._

      Person("Dave", "dave@example.com").toJson
      simpleJsonString.toJson shouldBe simpleJson
    }
    it("for Option[A] types") {
      import JsonWriterInstances._

      JsonInterface.toJson(Option(simpleJsonString)) shouldBe simpleJson
    }
  }
}
