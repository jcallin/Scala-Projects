package com.scalaprojects.algorithms.trees

import com.scalaprojects.datastructures.node.TreeNode

import scala.collection.mutable

object DepthFirstSearch {
  def inOrder(root: TreeNode): List[AnyVal] = {
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

}
