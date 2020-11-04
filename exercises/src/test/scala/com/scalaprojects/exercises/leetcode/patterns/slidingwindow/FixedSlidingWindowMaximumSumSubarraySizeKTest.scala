package com.scalaprojects.exercises.leetcode.patterns.slidingwindow

import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class FixedSlidingWindowMaximumSumSubarraySizeKTest extends ScalaProjectsSpec {
  it("Finds the maximum sub array of length k") {
    val nums      = Array(1, 3, -1, -3, 5, 3, 6, 7)
    val numsShort = Array(1, 3)
    val k         = 3

    FixedSlidingWindowMaximumSumSubarraySizeK.maxSlidingWindow(nums, k) shouldBe Array(3, 6, 7)
    FixedSlidingWindowMaximumSumSubarraySizeK.maxSlidingWindow(numsShort, k) shouldBe Array(1, 3)
  }
}
