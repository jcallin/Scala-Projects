package com.scalaprojects.algorithms.arrays

import scala.annotation.tailrec
import scala.collection.immutable.ArraySeq

object ReverseArrayRecursive {
  /**
   * Return an array reversed by recursion
   *
   * @param a array to reverse
   * @tparam T type of object in the array
   */
  def reverseArrayRecursive[T: Manifest](a: Array[T]): Array[T] = {
    @tailrec
    def reverseArrayHelper(a: Array[T], acc: Array[T]): Array[T] = {
      a match {
        // If we are finished, return the accumulator
        case Array() => acc
        // Take the next element and put it in front of the accumulator.
        // The last element will be at the start of the accumulator
        case Array(head, rest @ _*) =>
          // Must expand and use single parameter to initialize array
          // because Array[T]'s constructor is Array(x: T*)
          // If it were an Array[Int] we could use Array(x: Int, xs: Int*)
          reverseArrayHelper(Seq(rest).toArray, ArraySeq.unsafeWrapArray(Seq(head).toArray).toArray ++ acc)
      }
    }

    reverseArrayHelper(a, Array.empty[T])
  }
}
