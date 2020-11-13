package com.scalaprojects.exercises.leetcode

object LongestPalindromicSubstring {

  /** Given a string, return the longest palindromic substring
    *
    * @param s
    * @return
    */
  def longestPalindrome(s: String): String = { //scalastyle:ignore cyclomatic.complexity
    var output = ""
    if (s.length == 1) { s }
    else {
      for (index <- s.indices) {
        output = Seq(
          // Handle the base case where string is empty
          output,
          // Handle the case where string is an odd length
          helper(s, index, index),
          // Handle case where string is even length
          helper(s, index, index + 1)
        )
          .maxBy(s => s.length)
      }
      output
    }
  }

  private def helper(string: String, leftIndex: Int, rightIndex: Int): String = {
    var l = leftIndex
    var r = rightIndex
    while (l >= 0 && r < string.length && string(l) == string(r)) {
      l -= 1
      r += 1
    }

    string.substring(l + 1, r)
  }
}
