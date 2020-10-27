package com.scalaprojects.exercises.leetcode

import com.scalaprojects.datastructures.node.TreeNode
import com.scalaprojects.exercises.leetcode.datastructures.{TreeNode => TreeNodeUnsafe}

object SortedArrayToBst {

  def sortedArrayToBstUnsafe(nums: Array[Int]): TreeNodeUnsafe = {
    if (nums.length == 1) {
      return TreeNodeUnsafe(nums.head)
    } else if (nums.isEmpty) {
      return null
    }
    val middleIndex = nums.length / 2
    val above       = nums.take(middleIndex)
    val below       = nums.drop(middleIndex + 1)

    val result = TreeNodeUnsafe(nums(middleIndex))
    result.left = sortedArrayToBstUnsafe(above)
    result.right = sortedArrayToBstUnsafe(below)
    result
  }

  def sortedArrayToBstIdiomatic(nums: Array[Int]): TreeNode = {
    def sortedArrayToBstHelper(nums: List[Int]): Option[TreeNode] = {
      nums match {
        case Nil               => None
        case singleItem :: Nil => Some(TreeNode(singleItem))
        case items =>
          val midpoint = items.length / 2

          val root = TreeNode(items(midpoint))

          val firstHalf  = items.take(midpoint)
          val secondHalf = items.drop(midpoint + 1)
          root.left = sortedArrayToBstHelper(firstHalf)
          root.right = sortedArrayToBstHelper(secondHalf)
          Some(root)
      }

    }

    sortedArrayToBstHelper(nums.toList).getOrElse(
      throw new IllegalArgumentException("Input array mustn't be empty")
    )
  }
}
