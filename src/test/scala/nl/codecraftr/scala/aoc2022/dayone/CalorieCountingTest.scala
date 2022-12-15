package nl.codecraftr.scala.aoc2022.dayone

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CalorieCountingTest extends AnyFlatSpec with Matchers {
    "maxCaloriesCarriedBySingleElf" should "return the most calories a single elf carries" in {

    }

    it should "return 0 given no food is carried" in {
        CalorieCounter.maxCaloriesCarriedBySingleElf("") shouldBe 0
    }

    it should "return the calories given a single elf carrying one piece of food" in {
        CalorieCounter.maxCaloriesCarriedBySingleElf("1000") shouldBe 1000
    }
}
