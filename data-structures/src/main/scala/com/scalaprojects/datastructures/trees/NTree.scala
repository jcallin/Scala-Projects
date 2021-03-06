package com.scalaprojects.datastructures.trees

import com.scalaprojects.datastructures.collections.Queue
import com.scalaprojects.datastructures.node.TreeNode

object NTree {

  def nTreeFromValues(n: Int, values: List[AnyVal]): Option[TreeNode] = {
    var queue = Queue.apply[TreeNode]()
    values.headOption.map { rootVal =>
      val root = TreeNode(rootVal)
      // The first node to get children will be the root
      queue = queue.enqueue(root)

      // The children it gets will be the first n children in the values list
      // After they are added, the children get enqueued
      // Adding additional children dequeues the children (left first, then right), and adds the next n values as their children and enqueues them
      // For example, the root's rightmost child will get children before the root's leftmost child's children because it has priority in the queue
      values.tail.grouped(n).toList.foreach { pair =>
        val (parent, newQueue) = queue.dequeue
        queue = newQueue
        pair match {
          case first :: second :: Nil =>
            val leftChild  = TreeNode(first)
            val rightChild = TreeNode(second)
            parent.left = Some(leftChild)
            parent.right = Some(rightChild)
            queue = queue.enqueue(leftChild)
            queue = queue.enqueue(rightChild)

          case first :: Nil =>
            val leftChild = TreeNode(first)
            parent.left = Some(leftChild)
            queue = queue.enqueue(leftChild)
          case Nil =>
            queue
          // $COVERAGE-OFF$
          case _ :: _ :: _ =>
            throw new Exception("N tree > 2 not yet implemented :(")
          // $COVERAGE-ON$
        }
      }
      root
    }
  }

}
