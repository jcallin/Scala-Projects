package com.scalaprojects.exercises.leetcode.datastructures

/** Forms a linked list of nodes
  *
  * @param value integer value for the next
  * @param next the next node in the list, var for ease of use
  */
case class ListNode(value: Int, var next: Option[ListNode] = None) {

  /** Useful for seeing full list and don't want to implement equals
    * use this to check equals between the 2 output strings
    */
  override def toString: String = {
    def toStringHelper(l: ListNode): String = {
      l.next
        .map { lNextDefined => s"${l.value} -> " + toStringHelper(lNextDefined) }
        .getOrElse(s"${l.value}")
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
      .map(ListNode(_))
      .sliding(2)
      .map {
        case n1 :: n2 :: Nil =>
          n1.next = Some(n2)
          n1
        case nodes => throw new Exception(s".sliding(2) method must be applied to the sequence: $nodes")
      }.toList.headOption.getOrElse(ListNode(0, None))
  }
}
