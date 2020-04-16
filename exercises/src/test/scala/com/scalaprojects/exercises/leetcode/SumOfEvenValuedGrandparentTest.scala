package com.scalaprojects.exercises.leetcode

import com.scalaprojects.exercises.leetcode.datastructures.BinaryTree
import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class SumOfEvenValuedGrandparentTest extends ScalaProjectsSpec {
  it("should calculate for a regular binary tree") {
    val nums = Array(6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5)

    SumOfNodesWithEvenValueGrandparents.sumEvenGrandparent(BinaryTree.fromArray(nums)) shouldBe 18

  }
}
