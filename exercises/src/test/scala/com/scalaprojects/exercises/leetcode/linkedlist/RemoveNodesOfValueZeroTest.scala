package com.scalaprojects.exercises.leetcode.linkedlist

import com.scalaprojects.exercises.leetcode.datastructures.ListNode
import com.scalaprojects.exercises.leetcode.linkedlist.RemoveNodesOfValueZero._
import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class RemoveNodesOfValueZeroTest extends ScalaProjectsSpec {

  it("removes nodes of value 0") {
    val list = ListNode(
      0,
      ListNode(
        1,
        ListNode(
          0,
          ListNode(
            2,
            ListNode(
              0
            )
          )
        )
      )
    )
    removeNodesOfValueZero(list).toString shouldBe "1 -> 2"
  }

}
