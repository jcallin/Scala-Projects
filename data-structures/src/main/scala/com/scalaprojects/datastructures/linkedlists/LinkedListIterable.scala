package com.scalaprojects.datastructures.linkedlists

import com.scalaprojects.datastructures.node.SingleNode

/** A given linked list is iterable given a head node*/
class LinkedListIterable(head: Option[SingleNode])
    extends Iterator[Option[SingleNode]] {
  // Use var for simple way to store state
  // Todo: How to remove?
  private var nextNode: Option[SingleNode] = head

  override def hasNext: Boolean = nextNode.isDefined

  override def next: Option[SingleNode] = {
    val ret = nextNode
    nextNode = nextNode.flatMap(_.next)
    ret
  }
}
