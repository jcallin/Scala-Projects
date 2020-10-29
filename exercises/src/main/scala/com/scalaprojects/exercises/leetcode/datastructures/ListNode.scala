package com.scalaprojects.exercises.leetcode.datastructures

/** Forms a linked list of nodes
  *
  * @param value integer value for the next
  */
case class ListNode(var value: Int = 0, var _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int         = value

  /** Useful for seeing full list and don't want to implement equals
    * use this to check equals between the 2 output strings
    */
  override def toString: String = {
    def toStringHelper(l: ListNode): String = {
      if (l.next != null) {
        s"${l.x} -> " + toStringHelper(l.next)
      } else {
        s"${l.x}"
      }
    }
    toStringHelper(this)
  }

}

object ListNode {

  /** Creates a linked list from a list of values and returns the head node of the list
    *
    * @param values in order
    */
  def apply(values: Seq[Int]): ListNode = {
    values
      .map(v => ListNode(v))
      .sliding(2)
      .map {
        case n1 :: n2 :: Nil =>
          n1.next = n2
          n1
        case nodes =>
          throw new Exception(s".sliding(2) method must be applied to the sequence: $nodes")
      }
      .toList
      .headOption
      .getOrElse(ListNode())
  }
}
