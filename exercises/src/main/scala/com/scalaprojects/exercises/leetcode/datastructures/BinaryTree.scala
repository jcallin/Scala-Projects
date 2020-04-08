package com.scalaprojects.exercises.leetcode.datastructures

import com.scalaprojects.datastructures.collections.Queue

object BinaryTree {

  /** Converts an array of numbers of nulls (supported because of leetcode) to a binary tree
    *
    * @param values for nodes of the tree
    */
  def fromArray(values: Array[Any]): TreeNode = { // scalastyle:ignore cyclomatic.complexity method.length
    var queue = Queue.apply[TreeNode]()
    values.toList.headOption.map {
      case rootVal: Int =>
        val root = TreeNode(rootVal)
        // The first node to get children will be the root
        queue = queue.enqueue(root)

        // The children it gets will be the first n children in the values list
        // After they are added, the children get enqueued
        // Adding additional children dequeues the children (left first, then right), and adds the next n values as their children and enqueues them
        // For example, the root's rightmost child will get children before the root's leftmost child's children because it has priority in the queue
        values.toList.tail.grouped(2).toList.foreach { pair =>
          val (parent, newQueue) = queue.dequeue
          queue = newQueue
          pair match {
            case first :: second :: Nil =>
              first match {
                case f: Int =>
                  val leftChild = TreeNode(f)
                  parent.left = leftChild
                  queue = queue.enqueue(leftChild)
                case _ => null
              }
              second match {
                case s: Int =>
                  val rightChild = TreeNode(s)
                  parent.right = rightChild
                  queue = queue.enqueue(rightChild)
                case _ => null
              }

            case first :: Nil =>
              first match {
                case f: Int =>
                  val leftChild = TreeNode(f)
                  parent.left = leftChild
                  queue = queue.enqueue(leftChild)
                case _ => null
              }

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
  }.orNull
}
