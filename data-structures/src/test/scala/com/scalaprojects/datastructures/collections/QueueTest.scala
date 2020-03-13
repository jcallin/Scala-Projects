package com.scalaprojects.datastructures.collections

import com.scalaprojects.tools.testtools.ScalaProjectsSpec

class QueueTest extends ScalaProjectsSpec {
  describe("a queue") {
    val q = Queue[Int](1, 2)
    val inTestQ = new Queue[Int](in = List(1, 2), out = List.empty)
    it("should provide head access") {
      // head from out
      q.head shouldBe 1
      // head from in
      inTestQ.head shouldBe 2
    }
    it("should provide tail access") {
      // tail from out
      q.tail shouldBe Queue(2)
      // tail from in
      inTestQ.tail shouldBe Queue(1)
    }
    it("should enqueue and dequeue") {
      // Enqueue
      val enq = q.enqueue(3)
      enq.tail shouldBe Queue[Int](2, 3)

      // Dequeue from out
      enq.dequeue shouldBe (1, Queue[Int](2, 3))
      // Dequeue from in
      val deq = inTestQ.dequeue
      deq shouldBe (2, Queue[Int](1))
    }
    it("should retrieve items from in the queue") {
      val retrieveTestQ =
        new Queue[Int](in = List(1, 2, 3), out = List(4, 5, 6))
      retrieveTestQ.apply(1) shouldBe 5
      retrieveTestQ.apply(3) shouldBe 3
      assertThrows[NoSuchElementException] {
        retrieveTestQ(99)
      }
    }

    it("should throw exceptions on empty queue") {
      val emptyq = new Queue[Int](Nil, Nil)
      lazy val exceptionOps = List(emptyq.dequeue _, emptyq.tail _, emptyq.head _)

      exceptionOps.map(op => assertThrows[NoSuchElementException](op()))
    }

    it("should get a queue's length") {
      q.length shouldBe 2
    }
  }
}
