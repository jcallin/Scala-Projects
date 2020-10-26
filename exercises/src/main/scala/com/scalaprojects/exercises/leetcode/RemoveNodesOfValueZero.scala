package com.scalaprojects.exercises.leetcode

import com.scalaprojects.exercises.leetcode.datastructures.ListNode

object RemoveNodesOfValueZero {
  def removeNodesOfValueZero(head: ListNode): Option[ListNode] = {
    removeNodesOfValueZeroHelper(Some(head))
  }

  private def removeNodesOfValueZeroHelper(head: Option[ListNode]): Option[ListNode] = {
    head match {
      case Some(h) if h.value == 0 =>
        removeNodesOfValueZeroHelper(h.next)
      case Some(h) =>
        h.next = removeNodesOfValueZeroHelper(h.next)
        Some(h)
      case None => head
    }
  }
}
