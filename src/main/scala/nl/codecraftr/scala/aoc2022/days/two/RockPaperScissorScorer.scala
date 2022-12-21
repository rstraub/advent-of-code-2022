package nl.codecraftr.scala.aoc2022.days.two

object RockPaperScissorScorer {
  def score(strategySheet: String): Int = {
    val round = decode(strategySheet)
    round.score
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

private trait Scorable {
  def score: Int
}

private case class Round(opponent: Shape, player: Shape) extends Scorable {
  private sealed trait Result extends Scorable
  private case object Loss extends Result {
    override val score = 0
  }

  private case object Draw extends Result {
    override val score = 3
  }

  override def score: Int = {
    val result = if (opponent == player) Draw
    else Loss

    result.score + player.score
  }
}

private sealed trait Shape extends Scorable
private case object Rock extends Shape {
  override val score = 1
}

private case object Paper extends Shape {
  override val score = 2
}

private case object Scissors extends Shape {
  override val score = 3
}
