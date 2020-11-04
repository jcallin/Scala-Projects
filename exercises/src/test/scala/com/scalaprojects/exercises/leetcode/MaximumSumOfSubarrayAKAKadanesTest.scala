package com.scalaprojects.exercises.leetcode

import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class MaximumSumOfSubarrayAKAKadanesTest extends ScalaProjectsSpec {
  it("finds the maximum sum of a subarray") {
    val nums = Array(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    MaximumSumOfSubarrayAKAKadanes.maxSubArray(nums) shouldBe 6
    MaximumSumOfSubarrayAKAKadanes.maxSubArray(Array(1)) shouldBe 1
    MaximumSumOfSubarrayAKAKadanes.maxSubArray(Array(0)) shouldBe 0
    MaximumSumOfSubarrayAKAKadanes.maxSubArray(Array(-1)) shouldBe -1
    MaximumSumOfSubarrayAKAKadanes.maxSubArray(Array(-2, 1)) shouldBe 1
    MaximumSumOfSubarrayAKAKadanes.maxSubArray(Array(-1, -2)) shouldBe -1
    MaximumSumOfSubarrayAKAKadanes.maxSubArray(Array(-2147483647)) shouldBe -2147483647
  }
}
