package com.scalaprojects.exercises.leetcode

import com.scalaprojects.exercises.leetcode.datastructures.ListNode

object RemoveNodesOfValueZero {
  def removeNodesOfValueZero(head: ListNode): ListNode = {
    removeNodesOfValueZeroHelper(head)
  }

  private def removeNodesOfValueZeroHelper(head: ListNode): ListNode = {
    head match {
      case null => head
      case h if h.value == 0 =>
        removeNodesOfValueZeroHelper(h.next)
      case h =>
        h.next = removeNodesOfValueZeroHelper(h.next)
        h
    }
  }
}
