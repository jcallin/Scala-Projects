package com.scalaprojects.algorithms.trees

import com.scalaprojects.datastructures.node.TreeNode

import scala.collection.mutable

object DepthFirstIteration {

  /** Perform a preorder depth-first traversal of a binary tree using iteration and a stack
    *
    * @param root of the tree
    * @return the value of each node, pre-order traversal (Root, L, R)
    */
  def preOrder(root: TreeNode): List[AnyVal] = {
    val stack  = mutable.Stack[TreeNode]()
    val result = mutable.ListBuffer[AnyVal]()
    stack.push(root)

    while (stack.nonEmpty) {
      val current = stack.pop()
      result.append(current.value)
      current.left.foreach(stack.push)
      current.right.foreach(stack.push)
    }
    result.toList
  }

  /** Perform a postorder depth-first traversal of a binary tree using iteration and a stack
    *
    * @param root of the tree
    * @return the value of each node, post-order traversal (L, R, Root)
    */
  def postOrder(root: TreeNode): List[AnyVal] = {
    val stack  = mutable.Stack[TreeNode]()
    val result = mutable.ListBuffer[AnyVal]()
    stack.push(root)

    while (stack.nonEmpty) {
      val current = stack.pop()
      current.left.foreach(stack.push)
      current.right.foreach(stack.push)
      // Trick is to insert the head at the top of the result (O(1)), when everything has been processed it is at the back
      // satisfying the post-order requirement of R-L-Root
      result.insert(0, current.value)
    }
    result.toList
  }

  /** Perform an in-order depth-first traversal of a binary tree using iteration and a stack
    *
    * @param r root of the tree
    * @return the value of each node, in-order traversal (L, Root, R)
    */
  def inOrder(r: TreeNode): List[AnyVal] = {
    val stack                  = mutable.Stack[TreeNode]()
    val result                 = mutable.ListBuffer[AnyVal]()
    var root: Option[TreeNode] = Some(r)

    while (root.isDefined || stack.nonEmpty) {
      // Push all the left nodes on to the stack
      // If this isn't the first time, it will push the next parent node to visit onto the stack
      while (root.isDefined) {
        stack.push(root.get)
        root = root.get.left
      }
      root = Some(stack.pop())
      result.append(root.get.value)
      // Go to the next bottom-most right node of the tree
      root = root.get.right
    }

    result.toList
  }
}
