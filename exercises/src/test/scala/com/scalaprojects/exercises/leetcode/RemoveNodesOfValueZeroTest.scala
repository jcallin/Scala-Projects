package com.scalaprojects.exercises.leetcode

import com.scalaprojects.exercises.leetcode.RemoveNodesOfValueZero._
import com.scalaprojects.exercises.leetcode.datastructures.ListNode
import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class RemoveNodesOfValueZeroTest extends ScalaProjectsSpec {

  it("removes nodes of value 0") {
    val list = ListNode(
      0,
      Some(ListNode(
        1,
        Some(ListNode(
          0,
          Some(ListNode(
            2,
            Some(ListNode(
              0
            ))
          ))
        ))
      ))
    )
    removeNodesOfValueZero(list).get.toString shouldBe "1 -> 2"
  }

}
