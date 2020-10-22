package com.scalaprojects.exercises.leetcode

import scala.collection.mutable

object LongestSubstringWithoutRepeats {
  def longestSubstringWithoutRepeats(s: String): Int = {
    // Track each letter seen, as well as the index it was last seen at
    var longestSeen            = 0
    val lettersSeenInSubstring = mutable.Map[Char, Int]()
    var tracker                = 0

    while (tracker < s.length) {
      val currentLetter = s(tracker)

      if (!lettersSeenInSubstring.contains(currentLetter)) {
        lettersSeenInSubstring.addOne(currentLetter, tracker)
      } else {
        if (lettersSeenInSubstring.size > longestSeen) {
          longestSeen = lettersSeenInSubstring.size
        }

        // Go back to the last place the letter was seen
        tracker = lettersSeenInSubstring(currentLetter)
        // Reset the map
        lettersSeenInSubstring.clear()
      }
      tracker += 1
    }
    if (lettersSeenInSubstring.size > longestSeen) {
      longestSeen = lettersSeenInSubstring.size
    }
    longestSeen
  }
}
