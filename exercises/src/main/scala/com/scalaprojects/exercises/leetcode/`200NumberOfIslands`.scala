package com.scalaprojects.exercises.leetcode

// https://leetcode.com/problems/number-of-islands/
/** Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
  * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
  */
object `200NumberOfIslands` {
  def numIslands(grid: Array[Array[Char]]): Int = { // scalastyle:ignore cyclomatic.complexity
    var totalIslands = 0

    for (i <- grid.indices) {
      var rowIslands = 0
      val row        = grid(i)
      for (j <- row.indices) {
        val leftIsWater  = if (j - 1 < 0) true else row(j - 1) == '0'
        val rightIsWater = if (j + 1 == row.length) true else row(j + 1) == '0'

        val topIsWater    = if (i - 1 < 0) true else grid(i - 1)(j) == '0'
        val bottomIsWater = if (i + 1 == grid.length) true else grid(i + 1)(j) == '0'

        if (row(j) == '1' && grid.length == 1 && leftIsWater) {
          rowIslands += 1
        } else if (row(j) == '1') {
          val isIsolated = leftIsWater && topIsWater && rightIsWater && bottomIsWater
          if (isIsolated) {
            rowIslands += 1
          }
        }
      }
      totalIslands += rowIslands
    }
    totalIslands
  }
}
