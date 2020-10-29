package com.scalaprojects.algorithms.trees

import com.scalaprojects.datastructures.trees.BinaryTree
import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class DepthFirstRecursionTest extends ScalaProjectsSpec {
  describe("traverses a tree using") {

    /**            1
      *         /     \
      *       2       3
      *      / \     / \
      *    4    5  6    7
      */
    val root = BinaryTree(List(1, 2, 3, 4, 5, 6, 7)).root.get

    it("pre-order traversal") {
      DepthFirstRecursion.preOrder(root) shouldBe List(1, 2, 4, 5, 3, 6, 7)
    }
    it("post-order traversal") {
      DepthFirstRecursion.postOrder(root) shouldBe List(4, 5, 2, 6, 7, 3, 1)
    }
    it("in-order traversal") {
      DepthFirstRecursion.inOrder(root) shouldBe List(4, 2, 5, 1, 6, 3, 7)
    }
  }
}
