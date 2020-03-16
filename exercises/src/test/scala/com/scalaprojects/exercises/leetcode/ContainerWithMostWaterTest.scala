package com.scalaprojects.exercises.leetcode

import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class ContainerWithMostWaterTest extends ScalaProjectsSpec {
  it("should calculate the container with the greatest area") {
    val input = Array(1, 8, 6, 2, 5, 4, 8, 3, 7)
    ContainerWithMostWater.maxArea(input) shouldBe 49

  }

}
