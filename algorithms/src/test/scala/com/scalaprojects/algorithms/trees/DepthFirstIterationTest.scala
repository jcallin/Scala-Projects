package com.scalaprojects.algorithms.trees

import com.scalaprojects.datastructures.trees.BinaryTree
import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class DepthFirstIterationTest extends ScalaProjectsSpec {
  describe("when traversing a tree iteratively using DFS") {

    /**            1
      *         /     \
      *       2       3
      *      / \     / \
      *    4    5  6    7
      */
    val root = BinaryTree(List(1, 2, 3, 4, 5, 6, 7)).root.get
    it("uses pre-order traversal") {
      val result = List(1, 3, 7, 6, 2, 5, 4)
      DepthFirstIteration.preOrder(root) shouldBe result
    }
    it("uses post-order traversal") {
      val result = List(4, 5, 2, 6, 7, 3, 1)
      DepthFirstIteration.postOrder(root) shouldBe result
    }
    it("uses in-order traversal") {
      val result = List(4, 2, 5, 1, 6, 3, 7)
      DepthFirstIteration.inOrder(root) shouldBe result
    }
  }
}
