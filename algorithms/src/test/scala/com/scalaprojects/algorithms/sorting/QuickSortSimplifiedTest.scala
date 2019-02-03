package com.scalaprojects.algorithms.sorting

import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class QuickSortSimplifiedTest extends ScalaProjectsSpec {

  import com.scalaprojects.algorithms.sorting.QuickSortSimplified._

  describe("quick sort simplified scala") {
    it("should sort an array using simplified quicksort") {
      val a = List(2, 9, 5, 2, 8, 3, 5, 12, 7, 1, 0, 9, 1)
      quickSort(a) shouldBe a.sorted
      val b = List(2, 7, 2, 4, 3)
      quickSort(b) shouldBe b.sorted
    }
  }
}
