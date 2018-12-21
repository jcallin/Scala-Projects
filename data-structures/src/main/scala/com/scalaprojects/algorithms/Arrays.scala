package com.scalaprojects.algorithms

import scala.annotation.tailrec

object Arrays {
  /** Return an array reversed by recursion
    * @param a the array to reverse
    * @tparam T the type of object in the array
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
          reverseArrayHelper(rest.toArray, Array(Array(head) ++ acc: _*))
      }
    }
    reverseArrayHelper(a, Array.empty[T])
  }

  /** Return an array reversed by iteration
    * @param a the array to reverse
    * @tparam T the type of object in the array
    */
  def reverseArrayIterative[T](a: Array[T]): Array[T] = {
    // Set up bounds
    val start = 0
    val end = a.length - 1
    val mid = (a.length - 1) / 2

    // Set up ranges
    val i = start to mid
    val j = end to mid by -1

    // Reverse
    for((i, j) <- i.zip(j)) {
      val temp = a(i)
      a.update(i, a(j))
      a.update(j, temp)
    }
    a
  }
}
