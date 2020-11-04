package com.scalaprojects.exercises.leetcode.strings

object LongestCommonPrefix {
  def longestCommonPrefix(strs: Array[String]): String = {
    var prefix = ""
    var index  = 0

    while (index < 200) {
      val currentChars = strs.map { s =>
        if (index < s.length) {
          s(index)
        } else {
          return prefix
        }
      }

      if (currentChars.toSet.size == 1) {
        prefix += currentChars.head
      } else {
        return prefix
      }
      index += 1
    }

    prefix
  }
}
