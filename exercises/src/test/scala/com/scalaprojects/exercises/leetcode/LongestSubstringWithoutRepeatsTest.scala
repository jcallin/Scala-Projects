package com.scalaprojects.exercises.leetcode

import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class LongestSubstringWithoutRepeatsTest extends ScalaProjectsSpec {
  it("calculates for a string") {
    LongestSubstringWithoutRepeats.longestSubstringWithoutRepeats(
      "aaalongestaaa"
    ) shouldBe 8
    LongestSubstringWithoutRepeats.longestSubstringWithoutRepeats(
      "zzabcdalfki"
    ) shouldBe 8
  }
}
