package com.scalaprojects.algorithms.sequences

import scala.annotation.tailrec

object FibonacciRecursive {
  /**
   * Return the nth fibonacci number using recursion
   *
   * @param n the fibonacci number to calculate
   */
  def fibRecursive(n: Int): Int = {
    @tailrec
    def fibHelper(prev: Int, cur: Int, n: Int): Int = {
      // Start from the 1st fib (not the 0th)
      if (n > 1) fibHelper(cur, prev + cur, n - 1) else prev
      // Send the current value as the previous value
      // Send the result value as the new current
      // ... , cur, prev, ...
      // Next call will add the result and the previous value
    }
    fibHelper(0, 1, n)
  }
}

