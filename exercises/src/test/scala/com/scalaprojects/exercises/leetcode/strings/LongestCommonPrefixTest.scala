package com.scalaprojects.exercises.leetcode.strings

import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class LongestCommonPrefixTest extends ScalaProjectsSpec {
  it("finds the longest common prefix of an array of strings") {
    val input1 = Array("flower", "flow", "flight")
    val input2 = Array("dog", "racecar", "car")

    LongestCommonPrefix.longestCommonPrefix(input1) shouldBe "fl"
    LongestCommonPrefix.longestCommonPrefix(input2) shouldBe ""
  }
}
