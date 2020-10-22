package com.scalaprojects.algorithms.sorting

object MergeSort {

  /** Sort an array by mergesort
    * Stable:         yes
    * Time:  worst:   nlogn
    * average:        nlogn
    * best:           nlogn
    * Space:          n - need 2 subarray size (n / 2) for each array
    *
    * @param a array to sort
    */
  def mergeSort(a: Array[Int]): Array[Int] = {
    // We know an array of length 1 is sorted
    if (a.length < 2) {
      a
    } else {
      // Split the array in half
      val (left, right) = a.splitAt(a.length / 2)
      // Sort the left and right half
      mergeSort(left)
      mergeSort(right)
      // Merge the left and right half
      merge(left, right, a)
    }
  }

  /** Merge 2 sorted arrays into a third array, replacing its values with sorted values from the other 2
    *
    * @param l one array
    * @param r another array
    * @param a third array to merge to
    */
  def merge(l: Array[Int], r: Array[Int], a: Array[Int]): Array[Int] = {
    // i indexes l
    // j indexes r
    // k indexes a
    var i, j, k = 0
    // l and r will be sorted, so pick the smallest value of the left-most elements of each
    // Add this value to the final array
    while (i < l.length && j < r.length) {
      if (l(i) < r(j)) {
        a.update(k, l(i))
        i += 1
      } else {
        a.update(k, r(j))
        j += 1
      }
      k += 1
    }
    // Add whatever is left from l and r
    while (i < l.length) {
      a.update(k, l(i))
      i += 1
      k += 1
    }
    while (j < r.length) {
      a.update(k, r(j))
      j += 1
      k += 1
    }
    a
  }
}
