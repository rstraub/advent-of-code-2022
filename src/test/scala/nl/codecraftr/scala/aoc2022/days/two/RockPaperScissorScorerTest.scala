package nl.codecraftr.scala.aoc2022.days.two

import nl.codecraftr.scala.aoc2022.days.two.RockPaperScissorScorer.score
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class RockPaperScissorScorerTest extends AnyFlatSpec with Matchers {
  // TODO use table property tests
  "score" should "return 1 given a loss playing Rock" in {
    score("B X") shouldBe 1
  }

  it should "return 2 given a loss playing Paper" in {
    score("C Y") shouldBe 2
  }

  ignore should "return 3 given a loss playing Scissors" in {
    score("A Z") shouldBe 3
  }
}
