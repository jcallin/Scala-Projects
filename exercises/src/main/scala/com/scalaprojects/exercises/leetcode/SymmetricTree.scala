package com.scalaprojects.exercises.leetcode

import com.scalaprojects.exercises.leetcode.datastructures.TreeNode

object SymmetricTree {
  def isSymmetric(root: TreeNode): Boolean = {

    def isSymmetricHelper(root1: TreeNode, root2: TreeNode): Boolean = {
      // If we're comparing null nodes, they are the same
      if (root1 == null && root2 == null) {
        true
        // If one node or the other is null, but not both, false
      } else if ((root1 == null) ^ (root2 == null)) {
        false
        // If the nodes have the same value, good but need to ensure their mirror subtrees are symmetric
      } else if (root1.value == root2.value) {
        isSymmetricHelper(root1.left, root2.right) && isSymmetricHelper(root1.right, root2.left)
      } else {
        false
      }
    }

    if (root == null) {
      true
    } else {
      isSymmetricHelper(root.left, root.right)
    }
  }
}
