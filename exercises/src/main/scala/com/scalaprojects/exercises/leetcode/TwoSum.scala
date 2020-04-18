package com.scalaprojects.exercises.leetcode

import scala.collection.mutable

object TwoSum {
  def twoSums(nums: Array[Int], target: Int): Array[Int] = {
    val complementLookup = mutable.Map[Int, Int]()

    val result = nums.zipWithIndex.map {
      case (num, index) =>
        val complement = target - num
        // Does an element we have looked at exist such that adding it to `num` creates the target?
        val answer = if (complementLookup.contains(complement)) {
          Some(Array(complementLookup(complement), index))
        } else {
          None
        }

        // Add the number and its index to the array
        complementLookup.addOne(num, index)
        answer
    }
    // Take all defined options
    // Only one solution should exist
    result.flatten.headOption
    // If no solution exists, error
      .getOrElse(throw new IllegalArgumentException("No solution exists"))
  }
}
