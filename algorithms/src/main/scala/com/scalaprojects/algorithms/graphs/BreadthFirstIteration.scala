package com.scalaprojects.algorithms.graphs

import com.scalaprojects.datastructures.node.{GraphNode, TreeNode}

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object BreadthFirstIteration {

  /** Performs a breadth first traversal of a graph using iteration and a stack
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
