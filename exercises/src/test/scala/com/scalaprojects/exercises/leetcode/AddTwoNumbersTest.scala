package com.scalaprojects.exercises.leetcode

import com.scalaprojects.exercises.leetcode.datastructures.ListNode
import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class AddTwoNumbersTest extends ScalaProjectsSpec {
  val inputA0 = ListNode(2)
  val inputA1 = ListNode(4)
  val inputA2 = ListNode(3)

  val inputB0 = ListNode(5)
  val inputB1 = ListNode(6)
  val inputB2 = ListNode(4)

  val output0 = ListNode(7)
  val output1 = ListNode(0)
  val output2 = ListNode(8)

  val inputA = {
    inputA0.next = Some(inputA1)
    inputA1.next = Some(inputA2)
    inputA0
  }

  val inputB = {
    inputB0.next = Some(inputB1)
    inputB1.next = Some(inputB2)
    inputB0
  }

  val output = {
    output0.next = Some(output1)
    output1.next = Some(output2)
    output0
  }

  it("prints a linked list") {
    inputB.toString shouldBe "5 -> 6 -> 4"
  }

  describe("when adding two linked lists") {
    it("adds two linked lists of equal size") {
      AddTwoNumbers.addTwoNumbers(inputA, inputB).toString shouldBe output.toString
    }
    it("adds two linked lists of different sizes") {
      val inputC = inputA1
      AddTwoNumbers.addTwoNumbers(inputB, inputC).toString shouldBe "9 -> 9 -> 4"
      AddTwoNumbers.addTwoNumbers(inputC, inputB).toString shouldBe "9 -> 9 -> 4"
    }
  }
}
