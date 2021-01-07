package soundcommerce

case class Board(n: Int) {

  case class Ship(var health: Int)

  private[soundcommerce] var shipNum    = 0
  private[soundcommerce] val boardState = Array.fill[Option[Ship]](n, n)(None)

  //places a ship from x1,y1 to x2,y2 (assume good)
  def place(x1: Int, y1: Int, x2: Int, y2: Int): Unit = {
    val size = x2 - x1 + y2 - y1
    val ship = Ship(size)

    // Simple Range(x1, x2).zip(Range(y1, y2)) will not work since one of the ranges will be empty
    // Instead, if the x-dimension is constant, fill an array of size y2 with values equal to the constant x1 and vice versa
    val xs = if (x1 != x2) Range(x1, x2).toArray else Array.fill(y2)(x1)
    val ys = if (y1 != y2) Range(y1, y2).toArray else Array.fill(x2)(y1)

    xs.zip(ys)
      .foreach { case (i, j) =>
        boardState(i)(j) = Some(ship)
      }
    shipNum += 1
  }

  // returns miss, hit, sunk, game
  def shoot(x1: Int, y1: Int): String = {
    boardState(x1)(y1) match {
      case Some(ship) =>
        boardState(x1)(y1) = None
        handleHit(ship)
      case None =>
        "miss"
    }
  }

  private def handleHit(ship: Ship): String = {
    ship.health -= 1
    ship.health match {
      case health if health > 0 =>
        "hit"
      case _ =>
        shipNum -= 1
        if (shipNum == 0) "game" else "sunk"
    }
  }
}
