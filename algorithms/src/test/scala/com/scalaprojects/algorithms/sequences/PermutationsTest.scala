package com.scalaprojects.algorithms.sequences

import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class PermutationsTest extends ScalaProjectsSpec {
  import Permutations._
  describe("Permutations finder") {
    it("should find all permutations for a given list") {
      allPermutationsOf(List(1, 2, 3)) shouldBe List(
        List(1, 2, 3),
        List(2, 1, 3),
        List(2, 3, 1),
        List(1, 3, 2),
        List(3, 1, 2),
        List(3, 2, 1)
      )
    }
  }

}
