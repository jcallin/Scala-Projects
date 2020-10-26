package com.scalaprojects.exercises.leetcode

import com.scalaprojects.exercises.leetcode.datastructures.BinaryTree
import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class LeafSimilarTreesTest extends ScalaProjectsSpec {
  it("tells whether 2 trees are leaf similar") {
    val t1 = BinaryTree(Array(3, 5, 1, 6, 2, 9, 8, null, null, 7, 4))
    val t2 =
      BinaryTree(Array(3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8))

    LeafSimilarTrees.leafSimilar(t1, t2) shouldBe true
  }
  it("tells whether 2 trees are not leaf similar") {
    val t1 = BinaryTree(Array(18, 35, 22, null, 103, 43, 101, 58, null, 97))
    val t2 = BinaryTree(Array(94, 102, 17, 122, null, null, 54, 58, 101, 97))

    LeafSimilarTrees.leafSimilar(t1, t2) shouldBe false
  }
}
