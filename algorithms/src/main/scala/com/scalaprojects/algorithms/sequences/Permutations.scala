package com.scalaprojects.algorithms.sequences

object Permutations {
  type Permutation[T]  = List[T]
  type Permutations[T] = List[Permutation[T]]

  /**
    * Return all permutations of a given sequence
    *
    */
  def allPermutationsOf[T](sequence: List[T]): Permutations[T] = {
    def allPermutationsOfHelper(
        seq: List[T],
        acc: Permutations[T]
    ): Permutations[T] = {
      seq match {
        case Nil         => acc
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
    allPermutationsOfHelper(sequence, List.empty[Permutation[T]])
  }
}
