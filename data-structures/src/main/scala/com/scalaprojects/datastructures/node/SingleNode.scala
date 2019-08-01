package com.scalaprojects.datastructures.node

case class SingleNode(next: Option[SingleNode], override val value: AnyVal) extends Node
