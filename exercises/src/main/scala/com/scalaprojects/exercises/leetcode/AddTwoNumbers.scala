package com.scalaprojects.exercises.leetcode

/**
  * Definition for singly-linked list.
  *
  */
object AddTwoNumbers {

  case class ListNode(x: Int = 0, var next: Option[ListNode] = None) {

    /**
      * Useful for seeing full list and don't want to implement equals
      * use this to check equals between the 2 output strings
      */
    override def toString: String = {
      def toStringHelper(l: ListNode): String = {
        l.next
          .map { lNextDefined => s"${l.x} -> " + toStringHelper(lNextDefined) }
          .getOrElse(s"${l.x}")
      }
      toStringHelper(this)
    }
  }

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    addTwoNumbersHelper(Some(l1), Some(l2))
      .getOrElse(
        throw new IllegalArgumentException(s"Unable to add lists $l1 and $l2")
      )
  }

  private def addTwoNumbersHelper(
      l1: Option[ListNode],
      l2: Option[ListNode]
  ): Option[ListNode] = {
    (l1, l2) match {
      case (None, None)            => None
      case (Some(l1Defined), None) => Some(l1Defined)
      case (None, Some(l2Defined)) => Some(l2Defined)

      case (Some(l1Defined), Some(l2Defined)) => {
        val sum = l1Defined.x + l2Defined.x
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
}
