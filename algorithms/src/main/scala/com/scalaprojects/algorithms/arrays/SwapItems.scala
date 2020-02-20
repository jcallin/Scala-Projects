package com.scalaprojects.algorithms.arrays

object SwapItems {

  /**
    * Return an array with 2 elements swapped
    *
    * @param a    array to swap elements in
    * @param idx1 index to swap with idx2
    * @param idx2 index to swap with idx1
    * @tparam T type of elements in array being swapped
    */
  def swap[T](a: Array[T], idx1: Int, idx2: Int): Array[T] = {
    if (a.isEmpty || idx1 < 0 || idx2 < 0 || idx1 > a.length - 1 || idx2 > a.length - 1) {
      a
    } else {
      val temp = a(idx1)
      a.update(idx1, a(idx2))
      a.update(idx2, temp)
      a
    }
  }
}
