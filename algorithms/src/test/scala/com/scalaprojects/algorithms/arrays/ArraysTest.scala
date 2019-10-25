package com.scalaprojects.algorithms.arrays

import com.scalaprojects.tools.testtools.ScalaProjectsSpec

import com.scalaprojects.algorithms.arrays.FindAdjacentPairsWhichSumToN.findAdjacentPairsWhoseSumIs
import com.scalaprojects.algorithms.arrays.FindMissingNumberInRange.findMissingNumberIn
import com.scalaprojects.algorithms.arrays.RemoveDuplicates.removeDups
import com.scalaprojects.algorithms.arrays.ReverseArrayIterative.reverseArrayIterative
import com.scalaprojects.algorithms.arrays.ReverseArrayRecursive.reverseArrayRecursive
import com.scalaprojects.algorithms.arrays.SwapItems.swap
import com.scalaprojects.algorithms.arrays.Rotation.leftRotation
import com.scalaprojects.algorithms.arrays.Rotation.rightRotation
import com.scalaprojects.algorithms.arrays.BribingQueue.bribingQueue

class ArraysTest extends ScalaProjectsSpec {
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
    describe("when reversing an array by iteration") {
      it("should reverse non-empty even and odd length arrays") {
        val a = Array(1, 2, 3, 4, 5)
        val b = Array(1, 2, 3, 4)
        reverseArrayIterative(a) shouldBe Array(1, 2, 3, 4, 5).reverse
        reverseArrayIterative(b) shouldBe Array(1, 2, 3, 4).reverse
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
    describe("when removing duplicates from an array") {
      it("should remove duplicates from a non-empty array") {
        val a = Array(1, 2, 2, 3, 4, 5, 4, 1)
        removeDups(a) shouldBe Array(1, 2, 3, 4, 5)
      }
      it("should remove duplicates from an empty array") {
        val a = Array.empty[AnyVal]
        removeDups(a) shouldBe Array.empty[AnyVal]
      }
    }
    describe("when finding the missing number in a sequential array of integers") {
      it("should find the missing number in an array of size 9") {
        val a: Array[Int] = Array(1, 2, 3, 5, 6, 7, 8, 9, 10)
        findMissingNumberIn(a) shouldBe 4
      }
      it("should find the missing number in an empty array") {
        val a: Array[Int] = Array.empty[Int]
        findMissingNumberIn(a) shouldBe 0
      }
    }
    describe("when finding if all adjacent pairs in a list sum to a number") {
      it("should determine for a non-empty even list") {
        val a = List(0, 5, 1, 4, 2, 3, 4, 5)
        findAdjacentPairsWhoseSumIs(a, 5) shouldBe List((0, 5), (1, 4), (2, 3), (5, 0))
      }
      it("should determine for a non-empty odd list") {
        val a = List(0, 5, 1, 4, 2, 3, 5)
        findAdjacentPairsWhoseSumIs(a, 5) shouldBe List((0, 5), (1, 4), (2, 3), (5, 0))
      }
      it("should determine for a non-empty single-item list") {
        val a = List(5)
        findAdjacentPairsWhoseSumIs(a, 5) shouldBe List((5, 0))
        val b = List(2)
        findAdjacentPairsWhoseSumIs(b, 5) shouldBe List.empty
      }
    }
    describe("when swapping 2 elements of an array") {
      it("should swap 2 elements of a non-empty array") {
        val a = Array(1, 2, 3, 4, 5)
        swap(a, 1, 4) shouldBe Array(1, 5, 3, 4, 2)
      }
      it("should swap elements of an empty array") {
        val a = Array.empty[Int]
        swap(a, 0, 0) shouldBe Array.empty[Int]
      }
    }
    describe("when rotating an array to the left") {
      it("should rotate a non-empty array to the left") {
        val a = Array(1, 2, 3, 4, 5)
        leftRotation(a, 2) shouldBe Array(3, 4, 5, 1, 2)
      }
    }
    describe("when rotating an array to the right") {
      it("should rotate a non-empty array to the right") {
        val a = Array(1, 2, 3, 4, 5)
        rightRotation(a, 2) shouldBe Array(4, 5, 1, 2, 3)
      }
    }
    describe("when evaluating a bribing queue") {
      it("should identify the number of bribes for a bribable queue") {
        val a = Array(1, 0, 4, 2, 3)
        bribingQueue(a) shouldBe 3
      }
      it("notify of an unbribable queue") {
        val a = Array(1, 4, 0, 2, 3)
        assertThrows[IllegalStateException] {
          bribingQueue(a)
        }
      }
    }
  }
}
