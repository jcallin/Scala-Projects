package com.scalaprojects.algorithms.sorting

import com.scalaprojects.algorithms.arrays.SwapItems.swap

object QuickSort {
  /**
   * Sort an array by quicksort
   * Time:  worst:   n2 (randomize partition index for nlogn average)
   *        average: nlogn
   *        best:    n
   * Space:          n (in place)
   * @param a array to sort
   */
  def quickSort(a: Array[Int]): Array[Int] = {
    def quickSortHelper(a: Array[Int], start: Int, end: Int): Array[Int] = {
      if (start < end) {
        // Partition the array
        val pivotIndex: Int = partition(a, start, end)
        // Split the array around the partition point and send for partitioning of high and low sections
        quickSortHelper(a, start, pivotIndex - 1)
        quickSortHelper(a, pivotIndex + 1, end)
      } else {
        a
      }
    }

    /**
     * Return an array with a section partitioned around that section's last value
     * The last value takes a spot in the array such that elements to its left are smaller and elements to its right are larger
     * Elements in the array are swapped to achieve the above condition
     * @param a array to partition
     * @param start the start index of the section to partition
     * @param end the end index of the section to partition
     */
    def partition(a: Array[Int], start: Int, end: Int): Int = {
      val pivotValue = a(end)

      var pivotIndex = start

      // Starting at the beginning of the array, search for a value less than the pivot value.
      // Swap this value with the pivot index and move the pivot index forward.
      // The pivot index starts at the beginning of the array and moves forward only when its value is swapped with a value lower than the pivot value.
      // This way the pivot value can be swapped with the ending pivot index to ensure smaller values are to the left of the pivot index
      for (counter <- start until end) {
        if (a(counter) < pivotValue) {
          swap(a, counter, pivotIndex)
          pivotIndex += 1
        }
      }
      swap(a, pivotIndex, end)
      pivotIndex
    }

    if (a.isEmpty || a.length == 1) {
      a
    } else {
      quickSortHelper(a, 0, a.length - 1)
    }
  }
}
