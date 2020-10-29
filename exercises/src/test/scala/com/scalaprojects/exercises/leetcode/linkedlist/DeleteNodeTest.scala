package com.scalaprojects.exercises.leetcode.linkedlist

import com.scalaprojects.exercises.leetcode.datastructures.ListNode
import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class DeleteNodeTest extends ScalaProjectsSpec {
  it("deletes a node in a linked list") {
    val node1 = ListNode(0)
    val node2 = ListNode(1)
    val node3 = ListNode(3)
    node1.next = node2
    node2.next = node3

    val resultList = node1
    resultList.next = node3

    DeleteNode.deleteNode(node2)
    node1.next shouldBe node3
  }
}
