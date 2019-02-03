package com.scalaprojects.datastructures.collections

import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class QueueTest extends ScalaProjectsSpec {
  describe("a queue") {
    val q = Queue[Int](1, 2)
    it("should provide access to head and tail") {
      q.head shouldBe 1
      q.tail shouldBe Queue(2)
    }
    it("should enqueue and dequeue") {
      val enq = q.enqueue(6)
      enq.tail shouldBe Queue[Int](2, 6)
      val deq = enq.dequeue
      deq._1 shouldBe 1
      deq._2 shouldBe Queue[Int](2, 6)
    }
  }
}
