package com.scalaprojects.exercises.leetcode.patterns.slidingwindow

object FixedSlidingWindowMaximumSumSubarraySizeK {

  /** Find and return the subarray of size k whose sum is the maximum of all subarrays */
  def maxSlidingWindow(nums: Array[Int], k: Int): Array[Int] = {
    if (nums.length <= k) {
      nums
    } else {
      var lower              = 0
      var upper              = 0
      var maxSum             = 0
      var greatestArrayStart = 0

      // Create the initial window
      while (upper < k - 1) {
        maxSum += nums(upper)
        upper += 1
      }

      // Move the window, calculating the sum after each move and storing the starting index of that window
      while (upper < nums.length - 1) {
        var sum = maxSum
        upper += 1
        sum += nums(upper)
        sum -= nums(lower)
        lower += 1
        if (sum > maxSum) {
          maxSum = sum
          greatestArrayStart = lower
        }
      }

      // Take the maximum
      nums.slice(greatestArrayStart, greatestArrayStart + k)
    }
  }
}
