package com.scalaprojects.algorithms.arrays

object ReverseArrayIterative {

  /** Return an array reversed by iteration
    *
    * @param a array to reverse
    * @tparam T type of object in the array
    */
  def reverseArrayIterative[T](a: Array[T]): Array[T] = {
    // Set up bounds
    val start = 0
    val end   = a.length - 1
    val mid   = (a.length - 1) / 2

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
}
