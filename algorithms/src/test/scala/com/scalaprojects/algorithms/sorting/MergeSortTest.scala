package com.scalaprojects.algorithms.sorting

import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class MergeSortTest extends ScalaProjectsSpec {

  import com.scalaprojects.algorithms.sorting.MergeSort._

  describe("Merge sort") {
    it("should sort a non-empty array") {
      val a = Array(2, 9, 5, 2, 8, 3, 5, 12, 7, 1, 0, 9, 1)
      mergeSort(a) shouldBe a.sorted
      val b = Array(2, 7, 2, 4, 3)
      mergeSort(b) shouldBe b.sorted
    }
    it("should sort an empty array") {
      val a = Array.empty[Int]
      mergeSort(a) shouldBe a.sorted
    }
  }
  describe("merge") {
    it("should merge 2 sorted arrays into a single sorted array") {
      val a = Array(3, 8, 14)
      val b = Array(1, 2, 9, 15)
      val c = Array.ofDim[Int](a.length + b.length)
      merge(a, b, c) shouldBe (a ++ b).sorted
    }
  }
}
