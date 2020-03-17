package com.scalaprojects.exercises.leetcode

import com.scalaprojects.datastructures.node.TreeNode

object SortedArrayToBst {

  class TreeNodeUnsafe(var _value: Int) {
    var value: Int = _value
    var left: TreeNodeUnsafe = null
    var right: TreeNodeUnsafe = null
  }
  def sortedArrayToBstUnsafe(nums: Array[Int]): TreeNodeUnsafe = {
    if (nums.isEmpty) {
      null
    } else if (nums.length == 1) {
      new TreeNodeUnsafe(nums.head)
    } else {
      val midpoint = nums.length / 2
      val root = new TreeNodeUnsafe(nums(midpoint))

      val firstHalf = nums.take(midpoint)
      val secondHalf = nums.drop(midpoint + 1)
      root.left = sortedArrayToBstUnsafe(firstHalf)
      root.right = sortedArrayToBstUnsafe(secondHalf)
      root
    }
  }

  def sortedArrayToBstIdiomatic(nums: Array[Int]): TreeNode = {
    def sortedArrayToBstHelper(nums: List[Int]): Option[TreeNode] = {
      nums match {
        case Nil               => None
        case singleItem :: Nil => Some(TreeNode(singleItem))
        case items => {
          val midpoint = items.length / 2

          val root = TreeNode(items(midpoint))

          val firstHalf = items.take(midpoint)
          val secondHalf = items.drop(midpoint + 1)
          root.left = sortedArrayToBstHelper(firstHalf)
          root.right = sortedArrayToBstHelper(secondHalf)
          Some(root)
        }
      }

    }

    sortedArrayToBstHelper(nums.toList).getOrElse(
      throw new IllegalArgumentException("Input array mustn't be empty")
    )
  }
}
