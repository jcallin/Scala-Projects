package com.scalaprojects.datastructures.trees

import com.scalaprojects.datastructures.node.TreeNode
import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class BinaryTreeTest extends ScalaProjectsSpec {
  describe("Binary tree") {
    it("should build from a list of values") {
      val vals = List(0, 1, 2, 3, 4, 5)
      BinaryTree(vals) shouldBe
        BinaryTree(
          Some(
            TreeNode(
              0,
              Some(TreeNode(1, Some(TreeNode(3, None, None)), Some(TreeNode(4, None, None)))),
              Some(TreeNode(2, Some(TreeNode(5, None, None)), None))
            )
          )
        )
    }
    it("should build from no items and a single item") {
      val empty = List.empty[Int]
      BinaryTree(empty) shouldBe BinaryTree(None)

      val single = List(0)
      BinaryTree(single) shouldBe BinaryTree(Some(TreeNode(0, None, None)))
    }
  }

}
