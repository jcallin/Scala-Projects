package com.scalaprojects.algorithms

import org.scalatest.{FunSpec, Matchers, SeveredStackTraces}

class ArraysTest extends FunSpec with Matchers with SeveredStackTraces {
  import Arrays._
  describe("array algorithms") {
    describe("when reversing an array by recursion") {
      it("should reverse a non empty array") {
        val a = Array(1, 2, 3)
        reverseArrayRecursive(a) shouldBe Seq(1, 2, 3).reverse.toArray
      }
      it("should reverse an array with a single value") {
        val a = Array("single")
        reverseArrayRecursive(a) shouldBe Array("single")

      }
      it("should reverse an empty array") {
        val a = Array.empty[AnyVal]
        reverseArrayRecursive(a) shouldBe Array.empty[AnyVal]
      }
    }
  }
  describe("when reversing an array by iteration") {
    it("should reverse non-empty even and odd length arrays") {
      val a = Array(1, 2, 3, 4, 5)
      val b = Array(1, 2, 3, 4)
      reverseArrayIterative(a) shouldBe Array(1, 2, 3, 4, 5).reverse
      reverseArrayIterative(b) shouldBe Array(1, 2, 3, 4 ).reverse
    }
    it("should reverse an array with a single value") {
      val a = Array("single")
      reverseArrayIterative(a) shouldBe Array("single")

    }
    it("should reverse an empty array") {
      val a = Array.empty[AnyVal]
      reverseArrayIterative(a) shouldBe Array.empty[AnyVal]
    }
  }
}
