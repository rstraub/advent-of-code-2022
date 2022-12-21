package nl.codecraftr.scala.aoc2022.days.two

object RockPaperScissorScorer {
  def score(strategySheet: String): Int = {
    val round = parse(strategySheet)
    round.player.score
  }

  private def parse(strategySheet: String): Round = {
    if (strategySheet.endsWith("X")) Round(Rock, Rock)
    else if (strategySheet.endsWith("Y")) Round(Rock, Paper)
    else Round(Rock, Scissors)
  }
}

private case class Round(opponent: Shape, player: Shape)

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
