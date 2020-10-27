package com.scalaprojects.algorithms.graphs

import com.scalaprojects.datastructures.node.{GraphNode, TreeNode}

import scala.collection.mutable

object DepthFirst {

  /** Perform a depth-first traversal of a binary tree
    *
    * @param root of the tree
    * @return the value of each node, in depth first order
    */
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

  /** Perform a depth-first traversal of a graph
    */
  def depthFirstTraversal(node: GraphNode): List[AnyVal] = {
    val stack   = mutable.Stack[GraphNode]()
    val visited = mutable.Set[GraphNode]()
    val result  = mutable.ListBuffer[AnyVal]()
    stack.push(node)

    while (stack.nonEmpty) {
      val current = stack.pop()
      if (!visited.contains(current)) {
        result.append(current.value)
        current.next.map(n => stack.push(n))
        visited.add(current)
      }
    }

    result.toList
  }
}
