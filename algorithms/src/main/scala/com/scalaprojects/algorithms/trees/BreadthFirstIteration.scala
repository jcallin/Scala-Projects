package com.scalaprojects.algorithms.trees

import com.scalaprojects.datastructures.node.TreeNode

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object BreadthFirstIteration {

  /** Perform a level-order traversal of a binary tree and return nodes at each level, starting at the root
    * Uses iteration and a stack
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
}
