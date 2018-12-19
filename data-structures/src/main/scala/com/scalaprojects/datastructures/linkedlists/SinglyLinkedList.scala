package com.scalaprojects.datastructures.linkedlists

import scala.annotation.tailrec

case class SinglyLinkedList(head: Option[SingleNode])

object SinglyLinkedList {
  /** Return a [[SinglyLinkedList]] from a list of values
    * @param values for each node in the list
    */
  def apply(values: List[AnyVal]): SinglyLinkedList = {
    SinglyLinkedList(
      singlyLinkedListFromValues(values.reverse)
    )
  }

  /** Return the head of a singly linked list given a list of values
    * @param values for each node in the list
    */
  def singlyLinkedListFromValues(values: List[AnyVal]): Option[SingleNode] = {
    @tailrec
    def singlyLinkedListFromValuesHelper(values: List[AnyVal], acc: Option[SingleNode]): Option[SingleNode] = {
      values match {
        case Nil => None
        case head :: Nil => Some(SingleNode(next = acc, value = head))
        case head :: tail => singlyLinkedListFromValuesHelper(tail, Some(SingleNode(acc, head)))
      }
    }
    singlyLinkedListFromValuesHelper(values, None)
  }
}
