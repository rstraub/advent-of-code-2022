package nl.codecraftr.scala.aoc2022

import nl.codecraftr.scala.aoc2022.dayone.CalorieCounter

object Main extends App {
  println("Advent of Code 2022")
  println("-----------")
  println(s"Day One (I): ${CalorieCounter.maxCaloriesCarriedByTopElfInFile()}")
  println(s"Day One (II): ${CalorieCounter.maxCaloriesCarriedByTopThreeElvesInFile()}")
}
