package com.scalaprojects.algorithms.arrays

object BribingQueue {
  /**
   * Return the number of bribes needed to get to the input configuration. If not possible, raise an exception
   * An array of ascending integers from 0 to n. A larger integer may bribe a smaller integer directly in front of them to swap spots in line
   * Any integer may only bribe twice, but may be bribed any number of times
   *
   * @param q the array of ascending integers
   */
  def bribingQueue(q: Array[Int]): Int = {
    var bribes = 0
    for (i <- q.indices.reverse) {
      // If we see a bribee (expected value not equal to actual value in array), see how many times he has been bribed
      if (q(i) != i + 1) {
        // If we're still in the range of the array and the previous value is equal to the current expected value (it has bribed 1 up)
        if ((i - 1) >= 0 && q(i - 1) == (i + 1)) {
          // Unbribe the value at i - 1
          // Swap the current value and the previous value to achieve the expected configuration (1 unbribe)
          SwapItems.swap(q, i, i - 1)
          bribes += 1
        // If we're still in the range of the array and the previous previous value is equal to the current expected value (it has bribed 2 up)
        } else if (i - 2 >= 0 && q(i - 2) == (i + 1)) {
          // Unbribe the value at i - 2
          // Shift the current value and i - 1 value down 1. Then set the i value to the i - 2 value
          q(i - 2) = q(i - 1)
          q(i - 1) = q(i)
          q(i) = i + 1
          bribes += 2
        } else {
          throw new IllegalStateException("Too chaotic")
        }
      }
    }
    bribes
  }
}
