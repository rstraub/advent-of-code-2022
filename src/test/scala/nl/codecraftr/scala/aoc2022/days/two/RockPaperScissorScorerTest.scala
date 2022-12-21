package nl.codecraftr.scala.aoc2022.days.two

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks

class RockPaperScissorScorerTest
    extends AnyFlatSpec
    with Matchers
    with TableDrivenPropertyChecks {
  "score" should "return score of shape given a loss" in {
    val losses = Table(
      ("round", "score"),
      ("B X", 1),
      ("C Y", 2),
      ("A Z", 3)
    )

    forAll(losses) { (round: String, score: Int) =>
      RockPaperScissorScorer.score(round) shouldBe score
    }
  }
}
