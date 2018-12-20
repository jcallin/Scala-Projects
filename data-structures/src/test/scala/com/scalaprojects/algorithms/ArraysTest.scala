package com.scalaprojects.algorithms

import org.scalatest.{FunSpec, Matchers, SeveredStackTraces}

class ArraysTest extends FunSpec with Matchers with SeveredStackTraces {
  import Arrays._
  describe("array algorithms") {
    describe("when reversing an array") {
      it("should reverse a non empty array") {
        val a = Array(1, 2, 3)
        reverseArray(a) shouldBe Seq(1, 2, 3).reverse.toArray
      }
      it("should reverse an array with a single value") {
        val a = Array("single")
        reverseArray(a) shouldBe Array("single")

      }
      it("should reverse an empty array") {
        val a = Array.empty[AnyVal]
        reverseArray(a) shouldBe Array.empty[AnyVal]
      }
    }
  }
}
