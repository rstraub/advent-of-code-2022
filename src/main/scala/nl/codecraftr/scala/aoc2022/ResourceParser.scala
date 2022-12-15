package nl.codecraftr.scala.aoc2022

import scala.io.Source

object ResourceParser {
    def resourceAsString(fileName: String) = {
        val source = Source.fromResource(fileName)
        try source.mkString finally source.close()
    }
}
