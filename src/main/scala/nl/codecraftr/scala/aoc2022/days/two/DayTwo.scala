package nl.codecraftr.scala.aoc2022.days.two

import nl.codecraftr.scala.aoc2022.ResourceParser

object DayTwo extends App {
  private val sheet = ResourceParser.resourceAsString("daytwo.txt")

  println(s"Day Two: ${RockPaperScissorsScorer.score(sheet)}")
}
