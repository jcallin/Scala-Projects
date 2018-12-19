package com.scalaprojects.datastructures.linkedlists

/** Primitive Nodes for Linked Lists */
case class SingleNode(next: Option[SingleNode], value: AnyVal)
case class DoubleNode(next: Option[DoubleNode], prev: Option[DoubleNode], value: AnyVal)
