package nl.codecraftr.scala.aoc2022.days.two

import nl.codecraftr.scala.aoc2022.ResourceParser

object DayTwo extends App {
  private val sheet = ResourceParser.resourceAsString("daytwo.txt")

  println(s"Day Two, Part One: ${RockPaperScissorsScorer.score(sheet)}")
  println(s"Day Two, Part Two: ")
}
