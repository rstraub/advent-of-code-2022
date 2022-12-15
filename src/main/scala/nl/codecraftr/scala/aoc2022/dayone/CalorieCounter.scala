package nl.codecraftr.scala.aoc2022.dayone

import nl.codecraftr.scala.aoc2022.ResourceParser

object CalorieCounter {
    private val ELF_DIVIDER = "\n\n"

    private val FOOD_DIVIDER = "\n"

    def calculateMaxCalories(calorieSheet: String): Int = {
        if (calorieSheet.isBlank) 0
        else {
            val foodPerElf = calorieSheet
                .trim
                .split(ELF_DIVIDER)
                .map(_.split(FOOD_DIVIDER))
                .map(_.map(_.toInt))

            val caloriesPerElf = foodPerElf
                .map(_.sum)

            caloriesPerElf
                .max
        }
    }

    def calculateMaxCaloriesOfFile(): Int = {
        val sheet = ResourceParser.resourceAsString("calories.txt")
        calculateMaxCalories(sheet)
    }
}
