package com.scalaprojects.datastructures.node

case class TreeNode(
    override var value: AnyVal,
    var left: Option[TreeNode] = None,
    var right: Option[TreeNode] = None
) extends MutableNode
