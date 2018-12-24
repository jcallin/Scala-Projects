package datastructures.linkedlists

import com.scalaprojects.datastructures.linkedlists.{ SingleNode, SinglyLinkedList }
import org.scalatest.{ FunSpec, Matchers, SeveredStackTraces }

class LinkedListsTest extends FunSpec with Matchers with SeveredStackTraces {
  describe("Singly linked lists") {
    it("should create from values") {
      val sll = SinglyLinkedList(List(1, 2, 3))
      sll.head.get.value shouldBe 1
      sll.head.get.next.get.value shouldBe 2
    }
    it("should create an empty instance") {
      val sll = SinglyLinkedList(List.empty)
      sll.head shouldBe None
    }
    it("should be iterable") {
      val sll = SinglyLinkedList(List(1, 2))
      sll.next.get.value shouldBe 1
      sll.next.get.value shouldBe 2
      sll.next shouldBe None
    }
  }
}
