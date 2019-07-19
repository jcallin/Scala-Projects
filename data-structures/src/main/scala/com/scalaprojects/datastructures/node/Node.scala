package com.scalaprojects.datastructures.node

/** Primitive Nodes for Linked Lists */
trait Node {
  val next: Option[Node]
  val value: AnyVal
}
case class SingleNode(override val next: Option[SingleNode], override val value: AnyVal) extends Node
case class DoubleNode(override val next: Option[DoubleNode], prev: Option[DoubleNode], override val value: AnyVal) extends Node
