package com.scalaprojects.exercises.leetcode

import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class LongestPalindromicSubstringTest extends ScalaProjectsSpec {
  it("Find the longest palindromic substring") {
    val s1 = "babad"
    val s2 = "cbbd"
    val s3 = "ccad"
    val s4 = "aaaa"
    val s5 = "aaaaab"
    val s6 = "aacabdkacaa"
    LongestPalindromicSubstring.longestPalindrome(s1) shouldBe "bab"
    LongestPalindromicSubstring.longestPalindrome(s2) shouldBe "bb"
    LongestPalindromicSubstring.longestPalindrome(s3) shouldBe "cc"
    LongestPalindromicSubstring.longestPalindrome(s4) shouldBe "aaaa"
    LongestPalindromicSubstring.longestPalindrome(s5) shouldBe "aaaaa"
    LongestPalindromicSubstring.longestPalindrome(s6) shouldBe "aca"
  }
}
