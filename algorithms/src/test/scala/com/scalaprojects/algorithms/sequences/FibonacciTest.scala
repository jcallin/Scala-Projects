package com.scalaprojects.algorithms.sequences

import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class FibonacciTest extends ScalaProjectsSpec {
  describe("Fibonacci algorithms") {
    import FibonacciRecursive._
    it("should get the nth fib using recursion") {
      fibRecursive(10) shouldBe 34
    }
    import FibonacciStreams._
    it("should get the nth fib using streams") {
      fibStream(10) shouldBe 34
    }
  }
}
