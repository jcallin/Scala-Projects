package com.scalaprojects.datastructures.node

case class GraphNode(
    next: Seq[GraphNode] = Seq.empty[GraphNode],
    override val value: AnyVal
) extends Node
