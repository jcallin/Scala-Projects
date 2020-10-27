package com.scalaprojects.algorithms.graphs

import com.scalaprojects.datastructures.node.{GraphNode, TreeNode}

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object BreadthFirst {

  /** Perform a level-order traversal of a binary tree and return nodes at each level, starting at the root
    *
    * @param root of the tree
    */
  def levelOrder(root: TreeNode): List[List[AnyVal]] = {
    val queue  = mutable.Queue[TreeNode]()
    val result = ListBuffer[ListBuffer[AnyVal]]()
    queue.enqueue(root)

    while (queue.nonEmpty) {
      val levelSize    = queue.size
      val currentLevel = ListBuffer[AnyVal]()

      for (_ <- 0 until levelSize) {
        val current = queue.dequeue()
        currentLevel.append(current.value)

        current.left.foreach(queue.enqueue)
        current.right.foreach(queue.enqueue)
      }
      result.append(currentLevel)
    }
    result.map(_.toList).toList
  }

  /** Performs a breadth first traversal of a graph
    *
    * @param node at which to start the traversal
    * @return values in breadth-first order
    */
  def breadthFirstTraversal(node: GraphNode): List[AnyVal] = {
    val result  = mutable.ListBuffer[AnyVal]()
    val queue   = mutable.Queue[GraphNode]()
    val visited = mutable.Set[GraphNode]()
    queue.enqueue(node)

    while (queue.nonEmpty) {
      val levelSize = queue.size
      for (_ <- 0 until levelSize) {
        val current = queue.dequeue()
        if (!visited.contains(current)) {
          result.append(current.value)
          visited.add(current)
        }
        current.next.map(n => queue.enqueue(n))
      }
    }

    result.toList
  }

}
