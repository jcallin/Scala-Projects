package com.scalaprojects.exercises.leetcode.datastructures

object BinaryTree {
  def fromArray(nums: Array[Int]): TreeNode = {
    if (nums.isEmpty) {
      null
    } else if (nums.length == 1) {
      TreeNode(nums.head)
    } else {
      val midpoint = nums.length / 2
      val root = TreeNode(nums(midpoint))

      val firstHalf = nums.take(midpoint)
      val secondHalf = nums.drop(midpoint + 1)
      root.left = fromArray(firstHalf)
      root.right = fromArray(secondHalf)
      root
    }
  }
}
