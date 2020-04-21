package com.scalaprojects.exercises.leetcode

import com.scalaprojects.exercises.leetcode.datastructures.{
  BinaryTree,
  TreeNode
}
import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class SymmetricTreeTest extends ScalaProjectsSpec {
  describe("tells whether trees are symmetric") {
    it("an empty tree") {
      SymmetricTree.isSymmetric(null) shouldBe true
    }
    it("a single node tree") {
      SymmetricTree.isSymmetric(TreeNode(0)) shouldBe true
    }
    it("a tree with only 2 children") {
      val tree = BinaryTree.fromArray(Array(0, 1, 1))
      SymmetricTree.isSymmetric(tree) shouldBe true
    }
    it("a tree with a height greater than 2") {
      val tree = BinaryTree.fromArray(Array(1, 2, 2, 3, 4, 4, 3))
      SymmetricTree.isSymmetric(tree) shouldBe true
    }
  }
  describe("tells whether a tree is not symmetric") {
    it("an regularly asymmetric tree") {
      val tree = BinaryTree.fromArray(Array(1, 2, 2, null, 3, null, 3))
      SymmetricTree.isSymmetric(tree) shouldBe false
    }
    it("an almost symmetric tree where 2 values are different") {
      val tree = BinaryTree.fromArray(Array(0, 1, 2))
      SymmetricTree.isSymmetric(tree) shouldBe false
    }
    it(
      "an asymmetric tree where whose two sides have different numbers of nodes"
    ) {
      val tree = BinaryTree.fromArray(Array(0, 1))
      SymmetricTree.isSymmetric(tree) shouldBe false
    }

  }
}
