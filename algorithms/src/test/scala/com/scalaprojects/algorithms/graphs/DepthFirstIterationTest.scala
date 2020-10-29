package com.scalaprojects.algorithms.graphs

import com.scalaprojects.datastructures.node.GraphNode
import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class DepthFirstIterationTest extends ScalaProjectsSpec {
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
    DepthFirstIteration.depthFirstTraversal(graph) shouldBe Seq(0, 2, 3, 1, 4)
  }
}
