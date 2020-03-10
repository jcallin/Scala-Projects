package com.scalaprojects.exercises.leetcode

import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class TwoSumTest extends ScalaProjectsSpec {
  it("finds the target sum of 2 numbers in an array of numbers when only one solution exists") {
    val input = Array(1, 2, 3, 5, 6)
    TwoSum.twoSums(input, 5) shouldBe Array(1, 2)
  }
}
