package com.scalaprojects.algorithms

import scala.annotation.tailrec

object Arrays {
  /** Return a reversed array
    * @param a the array to reverse
    */
  def reverseArray[T: Manifest](a: Array[T]): Array[T] = {
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
          reverseArrayHelper(rest.toArray, Array(Array(head) ++ acc: _*))
      }
    }
    reverseArrayHelper(a, Array.empty[T])
  }
}
