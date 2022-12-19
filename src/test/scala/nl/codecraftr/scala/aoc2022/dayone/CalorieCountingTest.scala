package nl.codecraftr.scala.aoc2022.dayone

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CalorieCountingTest extends AnyFlatSpec with Matchers {
  "caloriesCarriedByTopElf" should "return 0 given no food is carried" in {
    CalorieCounter.caloriesCarriedByTopElf("") shouldBe 0
  }

  it should "return the calories given a single elf carrying one piece of food" in {
    CalorieCounter.caloriesCarriedByTopElf("1000") shouldBe 1000
  }

  it should "return the calories given a single elf carrying multiple pieces of food" in {
    CalorieCounter.caloriesCarriedByTopElf("""
              |1000
              |2000
              |""".stripMargin) shouldBe 3000
  }

  it should "return the calories given a multiple elves carrying food" in {
    CalorieCounter.caloriesCarriedByTopElf("""
              |1000
              |
              |2000
              |""".stripMargin) shouldBe 2000
  }

  it should "return the most calories a single elf carries" in {
    CalorieCounter.caloriesCarriedByTopElf("""
              |1000
              |2000
              |3000
              |
              |4000
              |
              |5000
              |6000
              |
              |7000
              |8000
              |9000
              |
              |10000
              |""".stripMargin) shouldBe 7000 + 8000 + 9000
  }

  "caloriesCarriedByTopThreeElves" should "return sum of calories carried by three top elves" in {
      CalorieCounter.caloriesCarriedByTopThreeElves(
          """
            |1000
            |2000
            |3000
            |
            |4000
            |
            |5000
            |6000
            |
            |7000
            |8000
            |9000
            |
            |10000
            |""".stripMargin) shouldBe (7000 + 8000 + 9000) +
          (5000 + 6000) +
          10000
  }
}
