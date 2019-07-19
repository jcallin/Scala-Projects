package com.scalaprojects.datastructures.linkedlists

import com.scalaprojects.datastructures.node.Node

/** A given linked list is iterable given a head node*/
class LinkedListIterable(head: Option[Node]) extends Iterator[Option[Node]] {
  // Use var for simple way to store state
  // Todo: How to remove?
  private var nextNode: Option[Node] = head

  override def hasNext: Boolean = nextNode.isDefined

  override def next: Option[Node] = {
    if (hasNext) {
      // Return the current node
      val ret = nextNode
      // Step to the next node
      nextNode = nextNode match {
        case Some(node) => node.next
        case _ => None
      }
      ret
    } else {
      None
    }
  }
}
