package nl.codecraftr.scala.aoc2022.dayone

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CalorieCountingTest extends AnyFlatSpec with Matchers {
    "maxCaloriesCarriedBySingleElf" should "return 0 given no food is carried" in {
        CalorieCounter.maxCaloriesCarriedBySingleElf("") shouldBe 0
    }

    it should "return the calories given a single elf carrying one piece of food" in {
        CalorieCounter.maxCaloriesCarriedBySingleElf("1000") shouldBe 1000
    }

    it should "return the calories given a single elf carrying multiple pieces of food" in {
        CalorieCounter.maxCaloriesCarriedBySingleElf(
            """
              |1000
              |2000
              |""".stripMargin) shouldBe 3000
    }

    it should "return the calories given a multiple elves carrying food" in {
        CalorieCounter.maxCaloriesCarriedBySingleElf(
            """
              |1000
              |
              |2000
              |""".stripMargin) shouldBe 2000
    }

    it should "return the most calories a single elf carries" in {
        CalorieCounter.maxCaloriesCarriedBySingleElf(
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
              |""".stripMargin) shouldBe 24000
    }
}
