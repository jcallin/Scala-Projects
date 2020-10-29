package com.scalaprojects.algorithms.trees

import com.scalaprojects.algorithms.trees
import com.scalaprojects.datastructures.trees.BinaryTree
import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class BreadthFirstIterationTest extends ScalaProjectsSpec {
  it("traverses a tree using BFS") {
    val values = List(1, 2, 3, 4, 5, 6, 7)
    val result = List(
      List(1),
      List(2, 3),
      List(4, 5, 6, 7)
    )
    trees.BreadthFirstIteration.levelOrder(BinaryTree(values).root.get) shouldBe result
  }
}
