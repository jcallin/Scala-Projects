package com.scalaprojects.datastructures.node

case class DoubleNode(
    next: Option[DoubleNode],
    prev: Option[DoubleNode],
    override val value: AnyVal
) extends Node
