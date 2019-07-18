package com.scalaprojects.algorithms.sequences

object Permutations {
  type Permutation[T] = List[T]
  /**
   * Return all permutations of a given sequence
   *
   */
  def allPermutationsOf[T](sequence: List[T]): List[List[T]] = {
    def allPermutationsOfHelper(seq: List[T], acc: List[List[T]]): List[List[T]] = {
      seq match {
        case Nil => acc
        case head :: Nil => List(head) :: acc
        case head :: tail =>
          allPermutationsOfHelper(tail, acc).flatMap {
            // Use a permutation and insert head at all places
            perm =>
              for (i <- 0 until (perm.length + 1)) yield {
                val (front, back) = perm.splitAt(i)
                front ::: List(head) ::: back
              }
          }
      }
    }
    allPermutationsOfHelper(sequence, List.empty[List[T]])
  }
}
