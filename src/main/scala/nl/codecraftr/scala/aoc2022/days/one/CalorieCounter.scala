package nl.codecraftr.scala.aoc2022.days.one

import nl.codecraftr.scala.aoc2022.ResourceParser

object CalorieCounter {
  private val ELF_DIVIDER = "\n\n"

  private val FOOD_DIVIDER = "\n"

  def caloriesCarriedByTopElf(calorieSheet: String): Int = {
    if (calorieSheet.isBlank) return 0

    val caloriesPerElf = toCaloriesPerElf(calorieSheet)

    caloriesPerElf.max
  }

  private def toCaloriesPerElf(calorieSheet: String) = {
    calorieSheet.trim
      .split(ELF_DIVIDER)
      .map(_.split(FOOD_DIVIDER))
      .map(_.map(_.toInt).sum)
  }

  def caloriesCarriedByTopThreeElves(calorieSheet: String): Int = {
    val caloriesPerElf = toCaloriesPerElf(calorieSheet)

    caloriesPerElf.sorted.reverse
      .take(3)
      .sum
  }

  def maxCaloriesCarriedByTopElfInFile(): Int = {
    executeOnSheet(caloriesCarriedByTopElf)
  }

  def maxCaloriesCarriedByTopThreeElvesInFile(): Int = {
    executeOnSheet(caloriesCarriedByTopThreeElves)
  }

  private def executeOnSheet[A](fn: String => A): A = {
    val sheet = ResourceParser.resourceAsString("calories.txt")
    fn(sheet)
  }
}
