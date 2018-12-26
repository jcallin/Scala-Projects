package com.scalaprojects.datastructures.linkedlists

import org.scalatest.{ FunSpec, Matchers, SeveredStackTraces }

class LinkedListIterableTest extends FunSpec with Matchers with SeveredStackTraces {
  describe("iterable linked lists") {
    it("should iterate forward") {
      // Set up a generic linked list for testing
      val testHead: Node = new Node {
        override val next = Some(new Node {
          override val next: Option[Node] = None
          override val value: AnyVal = 1
        })
        override val value: AnyVal = 0
      }
      val ill = new LinkedListIterable(Some(testHead))
      ill.next.get.value shouldBe 0
      ill.next.get.value shouldBe 1
    }
  }
}
