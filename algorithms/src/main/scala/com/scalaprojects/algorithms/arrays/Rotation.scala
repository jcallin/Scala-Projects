package com.scalaprojects.algorithms.arrays

object Rotation {

  /** Return an array with contents rotated to the left
    * @param a array to left rotate
    * @param n number of positions to rotate elements
    */
  def leftRotation(a: Array[Int], n: Int): Array[Int] = {
    val result: Array[Int] = a.clone
    for (i <- a.indices) {
      // Count back from the current index and use modulus to keep the range correct
      //
      // 1. Count back
      // 2. Take the mod to restrict the range. If this is negative, we'd have to get it back to the positive range by adding
      //    a multiple of the mod. This keeps the answer the same. We can add to a positive number as well because...
      // 3. After adding, the multiple may be out of the range. Which is fine. Bring it back in by modding the result
      val newPos = (((i - n) % a.length) + a.length) % a.length
      result(newPos) = a(i)
    }
    result
  }

  /** Return an array with contents rotated to the right
    * @param a array to right rotate
    * @param n number of positions to rotate elements
    */
  def rightRotation(a: Array[Int], n: Int): Array[Int] = {
    val result: Array[Int] = a.clone
    for (i <- a.indices) {
      // Count forward from the current index and use modulus to keep the range correct
      val newPos = (i + n) % a.length
      result(newPos) = a(i)
    }
    result
  }
}
