package nl.codecraftr.scala.aoc2022.days.two

object RockPaperScissorScorer {
  def score(strategySheet: String): Int = {
    val round = parse(strategySheet)
    round._2.score
  }

  private def parse(strategySheet: String): (Shape, Shape) = {
    if (strategySheet.endsWith("X")) (Rock, Rock)
    else if (strategySheet.endsWith("Y")) (Rock, Paper)
    else (Rock, Scissors)
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
