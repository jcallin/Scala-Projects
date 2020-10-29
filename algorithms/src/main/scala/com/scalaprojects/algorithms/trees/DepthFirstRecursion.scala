package com.scalaprojects.algorithms.trees

import com.scalaprojects.datastructures.node.TreeNode

import scala.collection.mutable

object DepthFirstRecursion {

  /** Return the values of nodes in a tree traversed using pre-order traversal and recursion
    *
    * @param root of the tree
    */
  def preOrder(root: TreeNode): List[AnyVal] = {
    val result = mutable.ListBuffer[AnyVal]()

    preOrderHelper(root)

    def preOrderHelper(root: TreeNode): Unit = {
      result.append(root.value)

      root.left.foreach(preOrderHelper)
      root.right.foreach(preOrderHelper)
    }

    result.toList
  }

  /** Return the values of nodes in a tree traversed using post-order traversal and recursion
    *
    * @param root of the tree
    */
  def postOrder(root: TreeNode): List[AnyVal] = {
    val result = mutable.ListBuffer[AnyVal]()

    postOrderHelper(root)

    def postOrderHelper(root: TreeNode): Unit = {
      root.left.foreach(postOrderHelper)
      root.right.foreach(postOrderHelper)
      result.append(root.value)
    }

    result.toList
  }

  /** Return the values of nodes in a tree traversed using in-order traversal and recursion
    *
    * @param root of the tree
    */
  def inOrder(root: TreeNode): List[AnyVal] = {
    val result = mutable.ListBuffer[AnyVal]()

    inOrderHelper(root)

    def inOrderHelper(root: TreeNode): Unit = {
      root.left.foreach(inOrderHelper)
      result.append(root.value)
      root.right.foreach(inOrderHelper)
    }

    result.toList
  }
}
