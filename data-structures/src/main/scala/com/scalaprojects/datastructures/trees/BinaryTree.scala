package com.scalaprojects.datastructures.trees

import com.scalaprojects.datastructures.node.TreeNode

case class BinaryTree(root: Option[TreeNode])

object BinaryTree {
  def apply(values: List[AnyVal]): BinaryTree = {
    BinaryTree(binaryTreeFromValues(values))
  }

  def binaryTreeFromValues(values: List[AnyVal]): Option[TreeNode] = {
    NTree.nTreeFromValues(2, values)
  }
}
