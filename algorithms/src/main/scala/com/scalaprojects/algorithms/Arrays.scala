package com.scalaprojects.algorithms

import scala.annotation.tailrec

object Arrays {
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
          reverseArrayHelper(rest.toArray, Array(Array(head) ++ acc: _*))
      }
    }

    reverseArrayHelper(a, Array.empty[T])
  }

  /**
   * Return an array reversed by iteration
   *
   * @param a array to reverse
   * @tparam T type of object in the array
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
    for ((i, j) <- i.zip(j)) {
      val temp = a(i)
      a.update(i, a(j))
      a.update(j, temp)
    }
    a
  }

  /**
   * Return an array with duplicates removed
   *
   * @param a array to de-duplicate
   * @tparam T type of object in the array
   */
  def removeDups[T: Manifest](a: Array[T]): Array[T] = {
    @tailrec
    def removeDupsHelper(a: Array[T], dups: Set[T], acc: Array[T]): Array[T] = {
      a match {
        // If we are finished, return the accumulator
        case Array() => acc
        case Array(head, rest @ _*) =>
          // Add head to the new set
          val newDups = dups + head
          // If we have seen the head before, don't add it to the acc array
          if (dups.contains(head)) {
            removeDupsHelper(rest.toArray, newDups, acc)
            // If we haven't seen the head before, add it to the acc array
          } else {
            removeDupsHelper(rest.toArray, newDups, acc ++ Array(head))
          }
      }
    }

    removeDupsHelper(a, Set.empty[T], Array.empty[T])
  }

  /**
   * Return the single missing number from an array of size n missing exactly 1 number in a sequence 1 to n
   *
   * @param a array to inspect
   */
  def findMissingNumberIn(a: Array[Int]): Int = {
    if (a.isEmpty) {
      0
    } else {
      // An array with n numbers should sum to those numbers added up
      // The incoming array will have 1 less number
      // If we subtract the incoming array's sum from the expected sum of a full array, we will get the missing number's value
      val shouldSumTo: Int = (1 to (a.length + 1)).sum
      shouldSumTo - a.sum
    }
  }

  type IntPair = (Int, Int)

  /**
   * Return a list of pairs of adjacent integers in an array which add to a sum
   * @param a array to check
   * @param sum check whether pairs add to this
   */
  def findAdjacentPairsWhoseSumIs(a: List[Int], sum: Int): List[IntPair] = {
    @tailrec
    def findAdjacentPairsWhoseSumIsHelper(a: List[Int], sum: Int, acc: List[IntPair]): List[IntPair] = {
      // Since we are processing 2 items at a time, we need cases for
      // 1. No items at the end of the list
      // 2. 1 item that may add to the sum
      // 3. 2 items that may add to the sum
      // 4. 3 items: 2 of which may add to the sum and a tail which needs to be checked for pairs
      a match {
        // At the end of the list, return the acc
        case Nil => acc
        case head :: Nil => if (checkSumIs(sum, head, 0)) acc ++ List((head, 0)) else acc
        // With 2 items left, add them to the acc only if they add to the sum
        case head :: next :: Nil =>
          val toAdd = addToAcc(sum, head, next)
          findAdjacentPairsWhoseSumIsHelper(List(next), sum, acc ++ toAdd)
        // With 2 items and the rest, add the 2 to the acc if they add, and find the rest
        case head :: next :: tail =>
          val toAdd = addToAcc(sum, head, next)
          findAdjacentPairsWhoseSumIsHelper(List(next) ++ tail, sum, acc ++ toAdd)
      }
    }

    def addToAcc(sum: Int, i1: Int, i2: Int): List[IntPair] = {
      if (checkSumIs(sum, i1, i2)) {
        List((i1, i2))
      } else {
        Nil
      }
    }

    def checkSumIs(sum: Int, i1: Int, i2: Int): Boolean = {
      i1 + i2 == sum
    }

    findAdjacentPairsWhoseSumIsHelper(a, sum, List.empty[IntPair])
  }

  /**
   * Return an array with 2 elements swapped
   * @param a array to swap elements in
   * @param idx1 index to swap with idx2
   * @param idx2 index to swap with idx1
   * @tparam T type of elements in array being swapped
   */
  def swap[T](a: Array[T], idx1: Int, idx2: Int): Array[T] = {
    if (a.isEmpty || idx1 < 0 || idx2 < 0 || idx1 > a.length - 1 || idx2 > a.length - 1) {
      a
    }
    else {
      val temp = a(idx1)
      a.update(idx1, a(idx2))
      a.update(idx2, temp)
      a
    }
  }
}
