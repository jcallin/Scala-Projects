package com.scalaprojects.exercises.leetcode

object ContainerWithMostWater {
  def maxArea(height: Array[Int]): Int = {
    var leftBarIndex = 0
    var rightBarIndex = height.length - 1
    var largestArea = 0

    while (leftBarIndex < rightBarIndex) {
      val leftBarHeight = height(leftBarIndex)
      val rightBarHeight = height(rightBarIndex)

      val width = Math.abs(leftBarIndex - rightBarIndex)

      val currentArea = Math.min(leftBarHeight, rightBarHeight) * width

      if (currentArea > largestArea) {
        largestArea = currentArea
      }

      if (leftBarHeight <= rightBarHeight) {
        leftBarIndex += 1
      } else {
        rightBarIndex -= 1
      }
    }

    largestArea
  }
}
