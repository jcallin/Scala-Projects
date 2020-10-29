package com.scalaprojects.exercises.leetcode.linkedlist

import com.scalaprojects.exercises.leetcode.datastructures.ListNode

object DeleteNode {

  /** Deletes a node from a linked list given only access to the node to be deleted
    * @param node to be deelted
    */
  def deleteNode(node: ListNode): Unit = {
    node.value = node.next.value
    node.next = node.next.next
  }
}
