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
    val roundGlyphs = encodedRound
      .split(" ")

    val opponent = decodeOpponentShape(roundGlyphs.head)
    val result = decodeResult(roundGlyphs.last)
    val player = result match {
      case Loss => opponent.winsFrom
      case Draw => opponent.draw
      case Win  => opponent.losesTo
    }

    Round(opponent, player)
  }

  private def decodeOpponentShape(encodedShape: String) = {
    encodedShape match {
      case "A" => Rock
      case "B" => Paper
      case "C" => Scissors
    }
  }

  private def decodeResult(encodedResult: String) = {
    encodedResult match {
      case "X" => Loss
      case "Y" => Draw
      case "Z" => Win
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
  override def score: Int = {
    val result =
      if (player.winsFrom == opponent) Win
      else if (player.losesTo == opponent) Loss
      else Draw

    result.score + player.score
  }
}

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

private sealed trait Shape extends Scorable {
  def winsFrom: Shape
  def draw: Shape
  def losesTo: Shape
}

private case object Rock extends Shape {
  override val score: Int = 1
  override val winsFrom: Shape = Scissors
  override val draw: Shape = Rock
  override val losesTo: Shape = Paper
}

private case object Paper extends Shape {
  override val score: Int = 2
  override val winsFrom: Shape = Rock
  override val draw: Shape = Paper
  override val losesTo: Shape = Scissors
}

private case object Scissors extends Shape {
  override val score: Int = 3
  override val winsFrom: Shape = Paper
  override val draw: Shape = Scissors
  override val losesTo: Shape = Rock
}
