package com.scalaprojects.exercises.leetcode

import com.scalaprojects.exercises.leetcode.datastructures.ListNode

object AddTwoNumbers {

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    addTwoNumbersHelper(Some(l1), Some(l2))
      .getOrElse(throw new IllegalArgumentException(s"Unable to add lists $l1 and $l2"))
  }

  private def addTwoNumbersHelper(l1: Option[ListNode], l2: Option[ListNode]): Option[ListNode] = {
    (l1, l2) match {
      case (None, None)            => None
      case (Some(l1Defined), None) => Some(l1Defined)
      case (None, Some(l2Defined)) => Some(l2Defined)

      case (Some(l1Defined), Some(l2Defined)) =>
        val sum = l1Defined.value + l2Defined.value
        if (sum < 10) {
          val answerNode = ListNode(sum)
          answerNode.next = addTwoNumbersHelper(l1Defined.next, l2Defined.next)
          Some(answerNode)
        } else {
          val answerNode = ListNode(sum - 10)
          answerNode.next = addTwoNumbersHelper(
            Some(ListNode(1)),
            addTwoNumbersHelper(l1Defined.next, l2Defined.next)
          )
          Some(answerNode)
        }
    }

  }
}
