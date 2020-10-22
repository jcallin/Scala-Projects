package com.scalaprojects.algorithms.sequences

object FibonacciStreams {

  /** Return the nth fibonacci number from a stream
    *
    * @param n the fibonacci number to calculate
    */
  def fibStream(n: Int): Int = {
    lazy val fibs: LazyList[Int] =
      0 #:: 1 #:: fibs.zip(fibs.tail).map { case (x, y) => x + y }
    fibs.take(n).toList.last
  }
}
