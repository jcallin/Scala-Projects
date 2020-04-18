package com.scalaprojects.exercises.leetcode

import com.scalaprojects.exercises.leetcode.datastructures.BinaryTree
import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class FlipEquivalentBinaryTreesTest extends ScalaProjectsSpec {
  it("tells whether 2 trees are flip equivalent") {
    val t1 = BinaryTree.fromArray(Array(1, 2, 3, 4, 5, 6, null, null, null, 7, 8))
    val t2 = BinaryTree.fromArray(Array(1, 3, 2, null, 6, 4, 5, null, null, null, null, 8, 7))

    FlipEquivalentBinaryTrees.Solution.flipEquiv(t1, t2) shouldBe true

    val t3 = BinaryTree.fromArray(Array(1, 3, 2, null, 6, 4, 5, null, null, null, null, 8, null))

    FlipEquivalentBinaryTrees.Solution.flipEquiv(t1, t3) shouldBe false
  }
}
