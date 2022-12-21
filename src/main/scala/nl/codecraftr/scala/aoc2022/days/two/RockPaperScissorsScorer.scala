package nl.codecraftr.scala.aoc2022.days.two

object RockPaperScissorsScorer {
  def score(encodedSheet: String): Int = {
    val tournament = SheetDecoder.decodeSheet(encodedSheet)
    tournament.score
  }
}

private object SheetDecoder {
  def decodeSheet(strategySheet: String): Tournament = {
    val rounds = strategySheet.trim
      .split("\n")
      .map(decodeRound)
      .toSeq
    Tournament(rounds)
  }

  private def decodeRound(encodedRound: String) = {
    val shapes = encodedRound
      .split(" ")
      .map(decodeShape)

    Round(shapes.head, shapes.last)
  }

  private def decodeShape(encodedShape: String) = {
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

private case class Tournament(rounds: Seq[Round]) extends Scorable {
  override def score: Int = rounds.map(_.score).sum
}

private case class Round(opponent: Shape, player: Shape) extends Scorable {
  private sealed trait Result extends Scorable
  private case object Loss extends Result {
    override val score = 0
  }
  private case object Draw extends Result {
    override val score = 3
  }
  private case object Win extends Result {
    override val score = 6
  }

  override def score: Int = {
    val result =
      if (player.beats == opponent) Win
      else if (opponent == player) Draw
      else Loss

    result.score + player.score
  }
}

private sealed trait Shape extends Scorable {
  def beats: Shape
}

private case object Rock extends Shape {
  override val score: Int = 1
  override val beats: Shape = Scissors
}

private case object Paper extends Shape {
  override val score: Int = 2
  override val beats: Shape = Rock
}

private case object Scissors extends Shape {
  override val score: Int = 3
  override val beats: Shape = Paper
}
