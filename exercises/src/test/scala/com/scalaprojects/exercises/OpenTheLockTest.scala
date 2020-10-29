package com.scalaprojects.exercises

import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class OpenTheLockTest extends ScalaProjectsSpec {
  case class TestCase(deadends: Array[String], target: String)
  it("opens the lock, returning the minimum number of turns to get the lock open") {
    val testCases = Map(
      TestCase(Array("0201", "0101", "0102", "1212", "2002"), "0202")                         -> 6,
      TestCase(Array("8888"), "0009")                                                         -> 1,
      TestCase(Array("8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"), "8888") -> -1
    )

    testCases.map { case (k, v) => OpenTheLock.openTheLock(k.deadends, k.target) shouldBe v }
  }
}
