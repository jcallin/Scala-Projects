package com.scalaprojects.exercises.leetcode

import com.scalaprojects.exercises.leetcode.datastructures.TreeNode

object FlipEquivalentBinaryTrees {

  /**
    * Definition for a binary tree node.
    *
    */
  object Solution {
    def flipEquiv(root1: TreeNode, root2: TreeNode): Boolean = {
      if (root1 == null && root2 == null) {
        true
      } else if (root1 == null ^ root2 == null) {
        false
      } else if (root1.value == root2.value) {

        (flipEquiv(root1.left, root2.left) ||
        flipEquiv(root1.left, root2.right)) &&
        (flipEquiv(root1.right, root2.left) ||
        flipEquiv(root1.right, root2.right))
      } else {
        false
      }

    }
  }
}
