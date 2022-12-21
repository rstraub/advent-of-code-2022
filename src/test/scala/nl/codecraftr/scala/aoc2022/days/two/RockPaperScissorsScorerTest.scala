package nl.codecraftr.scala.aoc2022.days.two

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks

class RockPaperScissorsScorerTest
    extends AnyFlatSpec
    with Matchers
    with TableDrivenPropertyChecks {
  "score" should "return score of shape given a loss" in {
    val losses = Table(
      ("round", "score"),
      ("A X", 3),
      ("B X", 1),
      ("C X", 2)
    )

    forAll(losses) { (round: String, score: Int) =>
      RockPaperScissorsScorer.score(round) shouldBe score
    }
  }

  it should "return score of shape plus three given a draw" in {
    val draws = Table(
      ("round", "score"),
      ("A Y", 1 + 3),
      ("B Y", 2 + 3),
      ("C Y", 3 + 3)
    )

    forAll(draws) { (round: String, score: Int) =>
      RockPaperScissorsScorer.score(round) shouldBe score
    }
  }

  it should "return score of shape plus six given a win" in {
    val wins = Table(
      ("round", "score"),
      ("A Z", 2 + 6),
      ("B Z", 3 + 6),
      ("C Z", 1 + 6)
    )

    forAll(wins) { (round: String, score: Int) =>
      RockPaperScissorsScorer.score(round) shouldBe score
    }
  }

  it should "return score of sample tournament" in {
    val sheet = """
        |A Y
        |B X
        |C Z
        |""".stripMargin

    RockPaperScissorsScorer.score(sheet) shouldBe 12
  }
}
