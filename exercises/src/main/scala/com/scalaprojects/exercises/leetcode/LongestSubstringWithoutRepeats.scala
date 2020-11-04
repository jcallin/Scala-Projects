package com.scalaprojects.exercises.leetcode

import scala.collection.mutable

object LongestSubstringWithoutRepeats {
  def longestSubstringWithoutRepeats(s: String): Int = {
    // Track each letter seen, as well as the index it was last seen at
    var longestSeen            = 0
    val lettersSeenInSubstring = mutable.Map[Char, Int]()
    var startingIndex          = 0 // Track the start of the substring

    for (currentIndex <- s.indices) {
      val currentLetter = s(currentIndex)

      // If we've seen the letter, set the starting index to 1 past the first occurrence of the letter
      if (lettersSeenInSubstring.contains(currentLetter)) {
        // Use .max() to ensure the starting index is not set to a letter before where it is already
        startingIndex = Math.max(startingIndex, lettersSeenInSubstring(currentLetter) + 1)
      }

      // Mark that we've seen the currentLetter at currentIndex
      lettersSeenInSubstring.addOne(currentLetter, currentIndex)

      // Check if the longest has been achieved
      // Don't worry about modifying the hashmap because we are just taking the diff of the 2 pointers
      longestSeen = Math.max(longestSeen, currentIndex - startingIndex + 1)
    }

    longestSeen
  }
}
