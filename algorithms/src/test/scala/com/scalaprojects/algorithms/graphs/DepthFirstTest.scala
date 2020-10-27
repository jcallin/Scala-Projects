package com.scalaprojects.algorithms.graphs

import com.scalaprojects.datastructures.node.GraphNode
import com.scalaprojects.datastructures.trees.BinaryTree
import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class DepthFirstTest extends ScalaProjectsSpec {
  it("traverses a tree using DFS") {
    val values = List(1, 2, 3, 4, 5, 6, 7)
    val result = List(1, 3, 7, 6, 2, 5, 4)
    DepthFirst.inOrder(BinaryTree(values).root.get) shouldBe result
  }
  it("traverses a generic graph using DFS") {
    val node1 = GraphNode(value = 1)
    val graph = GraphNode(
      value = 0,
      next = Seq(
        node1,
        GraphNode(value = 4),
        GraphNode(value = 2, next = Seq(GraphNode(value = 3, next = Seq(node1))))
      )
    )
    DepthFirst.depthFirstTraversal(graph) shouldBe Seq(0, 2, 3, 1, 4)
  }
}
