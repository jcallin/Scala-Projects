package com.scalaprojects.exercises.leetcode

object SymmetricTree {

  case class TreeNode(var value: Int) {
    var left: TreeNode = null
    var right: TreeNode = null
  }

  def isSymmetric(root: TreeNode): Boolean = {

    def isSymmetricHelper(root1: TreeNode, root2: TreeNode): Boolean = {
      if (root1 == null && root2 == null) {
        true
      } else if ((root1 == null) ^ (root2 == null)) {
        false
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