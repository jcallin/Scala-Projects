package com.scalaprojects.exercises.leetcode

import com.scalaprojects.exercises.leetcode.datastructures.TreeNode

object LeafSimilarTrees {
  def leafSimilar(root1: TreeNode, root2: TreeNode): Boolean = {

    def getLeafArray(root: TreeNode): Array[Int] = {
      if (isLeaf(root)) {
        Array(root.value)
      } else if (root.left == null) {
        getLeafArray(root.right)
      } else if (root.right == null) {
        getLeafArray(root.left)
      } else {
        getLeafArray(root.left) ++ getLeafArray(root.right)
      }
    }

    getLeafArray(root1) sameElements getLeafArray(root2)
  }

  def isLeaf(node: TreeNode): Boolean = node.left == null && node.right == null

}
