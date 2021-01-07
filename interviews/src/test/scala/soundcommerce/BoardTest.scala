package soundcommerce

import org.scalatest.FunSpec
import org.scalatest.Matchers.convertToAnyShouldWrapper

class BoardTest extends FunSpec {
  val board = Board(10)

  it("places ships") {
    // A 4-health ship in the x dimension
    board.place(0, 0, 4, 0)
    board.boardState(2)(0).isDefined shouldBe true

    // A 1-health ship
    board.place(4, 3, 4, 3)
    board.boardState(4)(3).isDefined shouldBe true

    board.shipNum shouldBe 2
  }
  describe("when shooting") {
    it("misses") {
      board.shoot(9, 9) shouldBe "miss"
    }
    describe("if a ship is hit") {
      it("registers a hit and eliminates that coordinate from play") {
        board.shoot(0, 0) shouldBe "hit"
        board.shoot(0, 0) shouldBe "miss"

        board.boardState(1)(0).get.health shouldBe 3
      }
      it("may sink the ship") {
        board.shoot(1, 0) shouldBe "hit"
        board.shoot(2, 0) shouldBe "hit"
        board.shoot(3, 0) shouldBe "sunk"
      }
      it("may win the game") {
        board.shoot(4, 3) shouldBe "game"
      }
    }
  }
}
