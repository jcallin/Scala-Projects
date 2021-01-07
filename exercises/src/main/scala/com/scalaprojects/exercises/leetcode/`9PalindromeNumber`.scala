package com.scalaprojects.exercises.leetcode

//https://leetcode.com/problems/palindrome-number/
object `9PalindromeNumber` {
  def isPalindrome(x: Int): Boolean = {
    val xString = x.toString
    if (x < 0) false
    else {
      xString.reverse == xString
    }
  }

  def isPalindromeInteger(x: Int): Boolean = {
    if (x < 0 || (x % 10 == 0 && x != 0)) false
    else {
      // Start firstHalf as x, we will divide it and reduce it to the first half only
      var firstHalf = x
      var lastHalf  = 0

      // The last half of x, digit by digit and append them to lastHalf
      // Once we've split x in half (firstHalf > lastHalf), we can stop
      while (firstHalf > lastHalf) {
        val lastDigit = firstHalf % 10
        lastHalf = lastHalf * 10 + lastDigit
        firstHalf /= 10
      }
      // Handle the case where the length is odd
      // When the length is an odd number, we can get rid of the middle digit by simply dividing by 10 once more
      // For example when the input is 12321, at the end of the while loop we get xNew = 12, lastHalf = 123,
      lastHalf == firstHalf || lastHalf / 10 == firstHalf
    }
  }
}
