package nl.codecraftr.scala.aoc2022.dayone

object CalorieCounter {
    def maxCaloriesCarriedBySingleElf(calorieSheet: String): Int = {
        if(calorieSheet.isBlank) 0
        else calorieSheet.toInt
    }
}
