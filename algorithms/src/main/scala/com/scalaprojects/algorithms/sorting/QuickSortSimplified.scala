package com.scalaprojects.algorithms.sorting

object QuickSortSimplified {

  type IntList = List[Int]

  /**
   * Sort an array by quicksort using some scala sugar and List instead of Array
   *
   * Time:
   * worst:   n2 (randomize partition index for nlogn average)
   * average: nlogn
   * best:    n
   *
   * Space:   n (in place)
   *
   * @param l list to sort
   */
  def quickSort(l: IntList): IntList = {
    def quickSortHelper(l: IntList): IntList = {
      l match {
        case Nil => Nil
        case list =>
          val (pivot, lesser, greater) = partition(list)
          quickSortHelper(lesser) ::: List(pivot) ::: quickSortHelper(greater)
      }
    }

    /**
     * Return partitions of a list partitioned around the first element
     *
     * @param l list to partition
     * @return (pivot value, items lesser than pivot, items greater than pivot)
     */
    def partition(l: IntList): (Int, IntList, IntList) = {
      val pivot :: rest = l
      val (lesser, greater) = rest.partition(_ < pivot)
      (pivot, lesser, greater)
    }

    quickSortHelper(l)
  }
}
