package com.scalaprojects.algorithms.sorting

import org.scalatest.{ FunSpec, Matchers, SeveredStackTraces }

class QuickSortTest extends FunSpec with Matchers with SeveredStackTraces {

  import com.scalaprojects.algorithms.sorting.QuickSort._

  describe("Sorting algorithms") {
    it("should sort an array using quicksort") {
      val a = Array(2, 9, 5, 2, 8, 3, 5, 12, 7, 1, 0, 9, 1)
      quickSort(a) shouldBe a.sorted
      val b = Array(2, 7, 2, 4, 3)
      quickSort(b) shouldBe b.sorted
    }
  }
}
