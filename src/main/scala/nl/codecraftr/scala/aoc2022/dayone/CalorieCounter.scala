package nl.codecraftr.scala.aoc2022.dayone

object CalorieCounter {
    private val ELF_DIVIDER = "\n\n"

    private val FOOD_DIVIDER = "\n"

    def maxCaloriesCarriedBySingleElf(calorieSheet: String): Int = {
        if (calorieSheet.isBlank) 0
        else {
            val elfs = calorieSheet
                .trim
                .split(ELF_DIVIDER)
            val foodsGroupedPerElf = elfs
                .map(_.split(FOOD_DIVIDER))
                .map(_.map(_.toInt))
            val caloriesPerElf = foodsGroupedPerElf
                .map(_.sum)
            caloriesPerElf
                .max
        }
    }
}
