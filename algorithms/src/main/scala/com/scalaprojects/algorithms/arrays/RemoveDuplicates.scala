package com.scalaprojects.algorithms.arrays

import scala.annotation.tailrec

object RemoveDuplicates {

  /** Return an array with duplicates removed
    *
    * @param a array to de-duplicate
    * @tparam T type of object in the array
    */
  def removeDups[T: Manifest](a: Array[T]): Array[T] = {
    @tailrec
    def removeDupsHelper(a: Array[T], dups: Set[T], acc: Array[T]): Array[T] = {
      a match {
        // If we are finished, return the accumulator
        case Array()                => acc
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
}
