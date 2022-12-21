package nl.codecraftr.scala.aoc2022.days.two

object RockPaperScissorScorer {
  def score(strategySheet: String): Int = {
    val round = decode(strategySheet)
    round.score()
  }

  private def decode(strategySheet: String): Round = {
    val shapes: Seq[Shape] = strategySheet
      .split(" ")
      .toSeq
      .map(toShape)

    Round(shapes.head, shapes.last)
  }

  private def toShape(encodedShape: String): Shape = {
    encodedShape match {
      case "A" | "X" => Rock
      case "B" | "Y" => Paper
      case "C" | "Z" => Scissors
    }
  }
}

private case class Round(opponent: Shape, player: Shape) {
  def score(): Int = {
    if (opponent == player) 3 + player.score
    else player.score
  }
}

private sealed trait Shape {
  val score: Int
}
private case object Rock extends Shape {
  override val score = 1
}

private case object Paper extends Shape {
  override val score = 2
}

private case object Scissors extends Shape {
  override val score = 3
}
