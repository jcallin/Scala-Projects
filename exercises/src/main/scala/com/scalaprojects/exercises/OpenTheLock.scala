package com.scalaprojects.exercises

import scala.collection.mutable

object OpenTheLock {
  def openTheLock(deadends: Array[String], target: String): Int = { // scalastyle:ignore cyclomatic.complexity
    val intialState = "0000"
    val deadEnds    = Set(deadends: _*)
    val visited     = mutable.Set(intialState)

    val queue: mutable.Queue[String] = mutable.Queue[String]()
    queue.enqueue(intialState)

    var moves = 0

    while (queue.nonEmpty) {
      val levelSize = queue.size
      // Remove all nodes from this level for inspection. Each level will count as one move
      for (_ <- 0 until levelSize) {
        val lockPosition = queue.dequeue()
        if (deadEnds.contains(lockPosition)) {
          // Skip this position
        } else if (lockPosition == target) {
          return moves
        } else {
          for (i <- 0 until 4) {
            val incrementChar = (c: Int) => if (c == 9) 0 else c + 1
            val decrementChar = (c: Int) => if (c == 0) 9 else c - 1

            // Can also do 'c' - '0'
            val currentChar = lockPosition.charAt(i).asDigit
            val incremented = lockPosition.substring(0, i) + incrementChar(
              currentChar
            ) + lockPosition.substring(i + 1)
            val decremented = lockPosition.substring(0, i) + decrementChar(
              currentChar
            ) + lockPosition.substring(i + 1)

            // Don't want to check one's we've visited and don't want to pollute the queue with deadends
            if (!visited.contains(incremented) && !deadEnds.contains(incremented)) {
              queue.enqueue(incremented)
              visited.add(incremented)
            }
            if (!visited.contains(decremented) && !deadEnds.contains(decremented)) {
              queue.enqueue(decremented)
              visited.add(decremented)
            }
          }
        }
      }
      // Each level checked counts as a move
      moves += 1
    }
    // If we've gone through the entire queue and not found the target, return -1
    -1
  }
}
