package com.scalaprojects.algorithms.arrays

object FindMissingNumberInRange {

  /**
    * Return the single missing number from an array of size n missing exactly 1 number in a sequence 1 to n
    *
    * @param a array to inspect
    */
  def findMissingNumberIn(a: Array[Int]): Int = {
    if (a.isEmpty) {
      0
    } else {
      // An array with n numbers should sum to those numbers added up
      // The incoming array will have 1 less number
      // If we subtract the incoming array's sum from the expected sum of a full array, we will get the missing number's value
      val shouldSumTo: Int = (1 to (a.length + 1)).sum
      shouldSumTo - a.sum
    }
  }
}
