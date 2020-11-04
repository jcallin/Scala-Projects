package com.scalaprojects.exercises.leetcode

object MaximumSumOfSubarrayAKAKadanes {

  /** AKA Kadane's Algorithm
    * Return the maximum sum of a subarray of the input array
    */
  def maxSubArray(nums: Array[Int]): Int = {
    for (i <- 1 until nums.length) {
      // Track the latest sum in the current position
      // If the previous position is positive, we reassign the value to their addition
      // If it is negative, we just reassign it to the current position's value
      // Array(0) works because this simply return nums.max on L16
      nums(i) = Math.max(nums(i), nums(i - 1) + nums(i))
    }
    nums.max
  }
}
