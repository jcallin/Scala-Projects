package com.scalaprojects.exercises.leetcode.datastructures

import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class ListNodeTest extends ScalaProjectsSpec {

  describe("ListNodeTest") {
    it("should apply") {
      ListNode(Seq(1, 2, 3)).toString shouldBe "1 -> 2 -> 3"
      ListNode(Seq(1, 2, 3, 4)).toString shouldBe "1 -> 2 -> 3 -> 4"
      ListNode(Seq.empty).toString shouldBe "0"
    }
  }
}
