package day01

import println
import readInput
import readLines

fun main() {
    fun part1(input: List<String>): Int {
        var zeroed = 0
        var dial = 50
        input.forEach {
            val direction = it.take(1)
            val clicks = it.drop(1).toInt()
            when (direction) {
                "L" -> dial -= clicks
                "R" -> dial += clicks
            }
            dial %= 100
            if (dial == 0) zeroed++
        }
        return zeroed
    }

    fun part2(input: List<String>): Int {
        var zeroed = 0
        var dial = 50
        input.forEach {
            val direction = it.take(1)
            val clicks = it.drop(1).toInt()
            when (direction) {
                "L" -> {
                    if (dial == 0) zeroed--
                    dial -= clicks
                    zeroed += (-dial + 100) / 100
                    dial = dial.mod(100)
                }
                "R" -> {
                    dial += clicks
                    zeroed += dial / 100
                    dial = dial.mod(100)
                }
            }
        }
        return zeroed
    }

    val testInput = readLines("/day01/test")
    check(part1(testInput) == 3)
    check(part2(testInput) == 6)

    val input = readLines("/day01/input")
    part1(input).println()
    part2(input).println()
}
