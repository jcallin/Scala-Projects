package com.scalaprojects.algorithms.trees

import com.scalaprojects.datastructures.trees.BinaryTree
import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class DepthFirstSearchTest extends ScalaProjectsSpec {
  it("traverses a tree using DFS") {
    val values = List(1, 2, 3, 4, 5, 6, 7)
    val result = List(1, 3, 7, 6, 2, 5, 4)
    DepthFirstSearch.inOrder(BinaryTree(values).root.get) shouldBe result
  }
}
