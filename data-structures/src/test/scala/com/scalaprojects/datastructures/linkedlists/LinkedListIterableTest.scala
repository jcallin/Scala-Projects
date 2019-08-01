package com.scalaprojects.datastructures.linkedlists

import com.scalaprojects.datastructures.node.SingleNode
import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class LinkedListIterableTest extends ScalaProjectsSpec {
  describe("iterable linked lists") {
    it("should iterate forward") {
      // Set up a generic linked list for testing
      val testHead: SingleNode = SingleNode(
        Some(SingleNode(None, 1)),
        0)
      val ill = new LinkedListIterable(Some(testHead))
      ill.next.get.value shouldBe 0
      ill.next.get.value shouldBe 1
      ill.next shouldBe None
    }
  }
}

