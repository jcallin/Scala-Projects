package com.scalaprojects.exercises.leetcode

import com.scalaprojects.datastructures.node.TreeNode
import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class SortedArrayToBstTest extends ScalaProjectsSpec {
  it("should convert a sorted array to a BST") {
    val input = Array(-10, -3, 0, 5, 9)
    val output = TreeNode(
      0,
      left = Some(TreeNode(-3, left = Some(TreeNode(-10)))),
      right = Some(TreeNode(9, left = Some(TreeNode(5))))
    )

    SortedArrayToBst.sortedArrayToBstIdiomatic(input) shouldBe output
    noException shouldBe thrownBy {
      SortedArrayToBst.sortedArrayToBstUnsafe(input)
    }
  }
}
