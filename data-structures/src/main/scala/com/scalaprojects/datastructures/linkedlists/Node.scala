package com.scalaprojects.datastructures.linkedlists

/** Primitive Nodes for Linked Lists */
sealed abstract class Node(val value: AnyVal)
case class SingleNode(next: Option[SingleNode] = None) extends Node
case class DoubleNode(next: Option[DoubleNode], prev: Option[DoubleNode]) extends Node
