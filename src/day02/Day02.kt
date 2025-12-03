package day02

import println
import readInput

fun main() {

    fun repeatedSequence(id: String): Boolean {
        val n = id.length
        for (i in 1..n / 2) {
            if (n % i == 0) {
                val substring = id.take(i)
                val repeatedString = buildString { repeat(n / i) { append(substring) } }
                if (repeatedString == id) {
                    return true
                }
            }
        }
        return false
    }

    fun duplicatedSequence(id: String): Boolean {
        if (id.length % 2 == 0) {
            val (first, second) = id.chunked(id.length / 2)
            return first == second
        }
        return false
    }

    fun mapInputToIds(input: String): Set<String> {
        return buildSet {
            input.split(',').forEach {
                val (start, end) = it.split('-')
                for (i in start.toLong()..end.toLong()) {
                    val id = i.toString()
                    add(id)
                }
            }
        }
    }

    fun part1(ids: Set<String>): Long {
        return ids.filter { duplicatedSequence(it) }.sumOf { it.toLong() }
    }

    fun part2(ids: Set<String>): Long {
        return ids.filter { repeatedSequence(it) }.sumOf { it.toLong() }
    }

    val testIds = mapInputToIds(readInput("day02/test"))
    check(part1(testIds) == 1227775554L)
    check(part2(testIds) == 4174379265L)

    val ids = mapInputToIds(readInput("day02/input"))
    part1(ids).println()
    part2(ids).println()
}
