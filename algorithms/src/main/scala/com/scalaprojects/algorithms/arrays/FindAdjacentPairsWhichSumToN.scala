package com.scalaprojects.algorithms.arrays

import scala.annotation.tailrec

object FindAdjacentPairsWhichSumToN {
  type IntPair = (Int, Int)

  /**
    * Return a list of pairs of adjacent integers in an array which add to a sum
    *
    * @param a   array to check
    * @param sum check whether pairs add to this
    */
  def findAdjacentPairsWhoseSumIs(a: List[Int], sum: Int): List[IntPair] = {
    @tailrec
    def findAdjacentPairsWhoseSumIsHelper(
        a: List[Int],
        sum: Int,
        acc: List[IntPair]
    ): List[IntPair] = {
      // Since we are processing 2 items at a time, we need cases for
      // 1. No items at the end of the list
      // 2. 1 item that may add to the sum
      // 3. 2 items that may add to the sum
      // 4. 3 items: 2 of which may add to the sum and a tail which needs to be checked for pairs
      a match {
        // At the end of the list, return the acc
        case Nil => acc
        case head :: Nil =>
          if (checkSumIs(sum, head, 0)) acc ++ List((head, 0)) else acc
        // With 2 items left, add them to the acc only if they add to the sum
        case head :: next :: Nil =>
          val toAdd = addToAcc(sum, head, next)
          findAdjacentPairsWhoseSumIsHelper(List(next), sum, acc ++ toAdd)
        // With 2 items and the rest, add the 2 to the acc if they add, and find the rest
        case head :: next :: tail =>
          val toAdd = addToAcc(sum, head, next)
          findAdjacentPairsWhoseSumIsHelper(
            List(next) ++ tail,
            sum,
            acc ++ toAdd
          )
      }
    }

    def addToAcc(sum: Int, addend1: Int, addend2: Int): List[IntPair] = {
      if (checkSumIs(sum, addend1, addend2)) {
        List((addend1, addend2))
      } else {
        Nil
      }
    }

    def checkSumIs(sum: Int, addend1: Int, addend2: Int): Boolean = {
      addend1 + addend2 == sum
    }

    findAdjacentPairsWhoseSumIsHelper(a, sum, List.empty[IntPair])
  }
}
