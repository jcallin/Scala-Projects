package com.scalaprojects.datastructures.linkedlists

import scala.annotation.tailrec

case class SinglyLinkedList(head: Option[Node])

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
  def singlyLinkedListFromValues(values: List[AnyVal]): Option[Node] = {
    @tailrec
    def singlyLinkedListFromValuesHelper(values: List[AnyVal], acc: Option[Node]): Option[Node] = {
      values match {
        case Nil => None
        case head :: Nil => Some(Node(acc, head))
        case head :: tail => singlyLinkedListFromValuesHelper(tail, Some(Node(acc, head)))
      }
    }
    singlyLinkedListFromValuesHelper(values, None)
  }
}
