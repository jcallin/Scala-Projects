package com.scalaprojects.datastructures.trees

import com.scalaprojects.datastructures.collections.Queue
import com.scalaprojects.datastructures.node.TreeNode

case class BinaryTree(root: Option[TreeNode])

object BinaryTree {
  def apply(values: List[AnyVal]): BinaryTree = {
    BinaryTree(binaryTreeFromValues(values))
  }

  def binaryTreeFromValues(values: List[AnyVal]): Option[TreeNode] = {
    var queue = Queue.apply[TreeNode]()
    values.headOption.map {
      rootVal =>
        val root = TreeNode(rootVal)
        // The first node to get children will be the root
        queue = queue.enqueue(root)

        // The children it gets will be the first 2 children in the values list
        // After they are added, the children get enqueued
        // Adding additional children dequeues the children (left first, then right), and adds the next 2 values as their children and enqueues them
        // For example, the root's right child will get children before the root's left child's children because it has priority in the queue
        values.tail.grouped(2).toList.foreach {
          pair =>
            val (parent, newQueue) = queue.dequeue
            queue = newQueue
            pair match {
              case first :: second :: Nil =>
                val leftChild = TreeNode(first)
                val rightChild = TreeNode(second)
                parent.left = Some(leftChild)
                parent.right = Some(rightChild)
                queue = queue.enqueue(leftChild)
                queue = queue.enqueue(rightChild)

              case first :: Nil =>
                val leftChild = TreeNode(first)
                parent.left = Some(leftChild)
                queue = queue.enqueue(leftChild)

              case e =>
                sys.error(s"Encountered an error, rest of items to add were $e")
            }
        }
        root
    }
  }
}
