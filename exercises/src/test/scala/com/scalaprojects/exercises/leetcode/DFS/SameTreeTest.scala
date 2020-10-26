package com.scalaprojects.exercises.leetcode.DFS

import com.scalaprojects.exercises.leetcode.datastructures.BinaryTree
import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class SameTreeTest extends ScalaProjectsSpec {
  it("tells whether 2 trees are the same") {
    val t1 = BinaryTree(Array(1, 2, 3, 4))
    val t2 = BinaryTree(Array(1, 2, 3, 4))
    val t3 = BinaryTree(Array(1, 2, 2, 4))
    val t4 = BinaryTree(Array.empty)

    SameTree.isSameTree(t1, t2) shouldBe true
    SameTree.isSameTree(t1, t3) shouldBe false
    SameTree.isSameTree(t4, t4) shouldBe true
    SameTree.isSameTree(t4, t1) shouldBe false
  }
}
