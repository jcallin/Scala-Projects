package com.scalaprojects.algorithms.graphs

import com.scalaprojects.datastructures.node.GraphNode

import scala.collection.mutable

object DepthFirstIteration {

  /** Perform a depth-first traversal of a graph using iteration and a stack */
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
