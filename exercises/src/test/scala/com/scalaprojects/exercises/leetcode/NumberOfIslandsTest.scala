package com.scalaprojects.exercises.leetcode

import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class NumberOfIslandsTest extends ScalaProjectsSpec {
  it("computes number of islands") {
    val archipelago = Array(
      Array('1', '1', '1', '1', '0'),
      Array('1', '1', '0', '1', '0'),
      Array('1', '1', '0', '0', '0'),
      Array('0', '0', '0', '0', '0')
    )
    `200NumberOfIslands`.numIslands(archipelago) shouldBe 1
  }
}
