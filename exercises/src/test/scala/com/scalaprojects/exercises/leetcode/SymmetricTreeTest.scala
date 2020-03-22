package com.scalaprojects.exercises.leetcode

import com.scalaprojects.exercises.leetcode.SymmetricTree.TreeNode
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
      val input = TreeNode(0)
      input.left = TreeNode(1)
      input.right = TreeNode(1)
      SymmetricTree.isSymmetric(input) shouldBe true
    }
    it("a tree with a height greater than 2") {
      val input = TreeNode(0)
      val l = TreeNode(1)
      val r = TreeNode(1)

      l.left = TreeNode(2)
      r.right = TreeNode(2)

      l.right = TreeNode(3)
      r.left = TreeNode(3)

      input.left = l
      input.right = r

      SymmetricTree.isSymmetric(input) shouldBe true

    }
  }
  describe("tells whether a tree is not symmetric") {
    it("an almost symmetric tree where 2 values are different") {
      val input = TreeNode(0)
      input.left = TreeNode(1)
      input.right = TreeNode(2)
      SymmetricTree.isSymmetric(input) shouldBe false
    }
    it("an asymmetric tree where whose two sides have different numbers of nodes") {
      val input = TreeNode(0)
      input.left = TreeNode(1)
      SymmetricTree.isSymmetric(input) shouldBe false
    }
  }
}
