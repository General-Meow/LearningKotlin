package com.paulhoang

data class Hampster(val name: String, val size: Int) {}

data class Song(val title: String, val category: String, val cost: Double) {}

fun main() {

    val numbers = listOf(1, 2, 3, 4, 5)
    val smallestNumber = numbers.min();
    val largestNumber = numbers.max();
    val sumOfAll = numbers.sumBy { it }
    println("the numbers list is $numbers")
    println("the smallest numbers list is $smallestNumber")
    println("the largest list is $largestNumber")
    println("the sum of list is $sumOfAll")

    val hampsters = listOf(Hampster("Joe", 10), Hampster("Bob", 5), Hampster("Berry", 20), Hampster("Smiles", 3))
    val smallestHampster = hampsters.minBy { it.size };
    val largesttHampster = hampsters.maxBy { it.size };
    println("the hampsters list is $hampsters")
    println("the smallest hampsters list is $smallestHampster")
    println("the largest hampster list is $largesttHampster")

    val largestHampsters = hampsters.filter { it.size > 10 }
    println("large hampsters $largestHampsters")
    val hampsterSizes = hampsters.map { it.size }
    println("all sizes $hampsterSizes")

    var sumOfAllHampsterSizes = hampsters.map { it.size }.sum()
    println("sum of all sizes $sumOfAllHampsterSizes")

    val musicCollection = listOf(Song("Gold Digger", "RnB", 10.0), Song("Hey Ya!", "Pop", 5.99),
        Song("Steal My Sunshine", "Pop", 1.0), Song("In too deep", "Alt", 2.99), Song("All the small things", "Alt", 4.99))

    val categoriesToSongs = musicCollection.groupBy { it.category }
    println("music grouped by category $categoriesToSongs")

    val words = listOf("A", "list", "of", "words")
    val wordsFolded = words.fold("") { runningResult, item -> "$runningResult$item " }
    println("all words joined: '$wordsFolded'")
}