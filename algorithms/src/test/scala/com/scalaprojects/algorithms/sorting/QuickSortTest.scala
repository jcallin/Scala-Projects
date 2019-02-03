package com.scalaprojects.algorithms.sorting

import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class QuickSortTest extends ScalaProjectsSpec {

  import com.scalaprojects.algorithms.sorting.QuickSort._

  describe("quick sort traditional") {
    it("should sort an array using traditional quicksort") {
      val a = Array(2, 9, 5, 2, 8, 3, 5, 12, 7, 1, 0, 9, 1)
      quickSort(a) shouldBe a.sorted
      val b = Array(2, 7, 2, 4, 3)
      quickSort(b) shouldBe b.sorted
    }
  }
}
