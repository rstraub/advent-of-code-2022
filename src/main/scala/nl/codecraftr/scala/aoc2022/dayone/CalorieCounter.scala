package nl.codecraftr.scala.aoc2022.dayone

import nl.codecraftr.scala.aoc2022.ResourceParser

object CalorieCounter {
  private val ELF_DIVIDER = "\n\n"

  private val FOOD_DIVIDER = "\n"

  def caloriesCarriedByTopElf(calorieSheet: String): Int = {
    if (calorieSheet.isBlank) return 0

    val foodPerElf = calorieSheet.trim
      .split(ELF_DIVIDER)
      .map(_.split(FOOD_DIVIDER))
      .map(_.map(_.toInt))

    val caloriesPerElf = foodPerElf
      .map(_.sum)

    caloriesPerElf.max
  }

  def caloriesCarriedByTopThreeElves(calorieSheet: String): Int = {
    0
  }

  def calculateMaxCaloriesOfFile(): Int = {
    val sheet = ResourceParser.resourceAsString("calories.txt")
    caloriesCarriedByTopElf(sheet)
  }
}
