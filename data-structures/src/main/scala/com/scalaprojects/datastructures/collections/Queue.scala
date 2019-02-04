package com.scalaprojects.datastructures.collections

import scala.collection.AbstractSeq

/**
 * A simple implementation similar to [[scala.collection.immutable.Queue]]
 *
 * @param in list of items that have been inserted, with most recent insertion at head
 * @param out list queued items, with the next items to be removed at the head
 * @tparam A type of item in the queue
 */
class Queue[A](val in: List[A], out: List[A]) extends AbstractSeq[A] {
  def enqueue(item: A): Queue[A] = new Queue(item :: in, out)
  def dequeue: (A, Queue[A]) = {
    out match {
      // No items in out list, replace out list with reversed in list and dequeue first item
      case Nil if in.nonEmpty =>
        val newOut = in.reverse; (newOut.head, new Queue(Nil, newOut.tail))
      // Just take from the out list
      case x :: xs => (x, new Queue(in, xs))
      // No out or in list
      case _ => throw new NoSuchElementException("dequeue on empty queue")
    }
  }

  override def head: A =
    if (out.nonEmpty) out.head
    else if (in.nonEmpty) in.last
    else throw new NoSuchElementException("head on empty queue")

  override def tail: Queue[A] =
    if (out.nonEmpty) new Queue[A](in, out.tail)
    else if (in.nonEmpty) new Queue[A](Nil, in.reverse.tail)
    else throw new NoSuchElementException("tail on empty queue")

  // AbstractSeq methods
  override def iterator: Iterator[A] = (out ::: in.reverse).toIterator
  override def apply(idx: Int): A = {
    // If we can take from the out list
    if (idx < out.length) out.apply(idx)
    else {
      // If idx is in the in list
      val otherOuts = in.reverse
      val idxOtherOuts = idx - out.length
      if (idxOtherOuts < otherOuts.length) otherOuts.apply(idxOtherOuts)
      else throw new NoSuchElementException("index out of range")
    }
  }
  override def length: Int = out.length + in.length
}

object Queue {
  def apply[A](items: A*): Queue[A] = new Queue[A](Nil, items.toList)
}
