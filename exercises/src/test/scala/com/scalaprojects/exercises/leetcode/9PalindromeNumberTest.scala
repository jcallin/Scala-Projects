package com.scalaprojects.exercises.leetcode

import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class PalindromeNumberTest extends ScalaProjectsSpec {
  val testCases       = Seq(0, -101, 101, 11, 5, 78587, 5000)
  val expectedResults = Seq(true, false, true, true, true, true, false)
  it("tells whether a number is palindromic using string manipulation") {
    testCases.map(`9PalindromeNumber`.isPalindrome) shouldBe expectedResults
  }
  it("tells whether a number is palindromic using math") {
    testCases.map(`9PalindromeNumber`.isPalindromeInteger) shouldBe expectedResults
  }
}
