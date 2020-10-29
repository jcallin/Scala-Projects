package com.scalaprojects.exercises.leetcode

import com.scalaprojects.exercises.leetcode.datastructures.ListNode

object AddTwoNumbers {

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    addTwoNumbersHelper(l1, l2)
  }

  private def addTwoNumbersHelper(l1: ListNode, l2: ListNode): ListNode = {
    (l1, l2) match {
      case (null, null)      => null
      case (l1Defined, null) => l1Defined
      case (null, l2Defined) => l2Defined

      case (l1Defined, l2Defined) =>
        val sum = l1Defined.value + l2Defined.value
        if (sum < 10) {
          val answerNode = ListNode(sum)
          answerNode.next = addTwoNumbersHelper(l1Defined.next, l2Defined.next)
          answerNode
        } else {
          val answerNode = ListNode(sum - 10)
          answerNode.next = addTwoNumbersHelper(
            ListNode(1),
            addTwoNumbersHelper(l1Defined.next, l2Defined.next)
          )
          answerNode
        }
    }

  }
}
