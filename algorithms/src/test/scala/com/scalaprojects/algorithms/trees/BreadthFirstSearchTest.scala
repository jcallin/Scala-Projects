package com.scalaprojects.algorithms.trees

import com.scalaprojects.datastructures.node.GraphNode
import com.scalaprojects.datastructures.trees.BinaryTree
import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class BreadthFirstSearchTest extends ScalaProjectsSpec {
  it("traverses a tree using BFS") {
    val values = List(1, 2, 3, 4, 5, 6, 7)
    val result = List(
      List(1),
      List(2, 3),
      List(4, 5, 6, 7)
    )
    BreadthFirstSearch.levelOrder(BinaryTree(values).root.get) shouldBe result
  }
  it("traverses a generic graph using BFS") {
    val node1 = GraphNode(value = 1)
    val graph = GraphNode(
      value = 0,
      next = Seq(
        node1,
        GraphNode(value = 4),
        GraphNode(value = 2, next = Seq(GraphNode(value = 3, next = Seq(node1))))
      )
    )
    BreadthFirstSearch.breadthFirstSearch(graph) shouldBe Seq(0, 1, 4, 2, 3)
  }

}
