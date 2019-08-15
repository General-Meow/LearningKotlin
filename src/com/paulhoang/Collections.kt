package com.paulhoang

class Dummy(var aProperty: String) {
}
fun main() {
    val setExample = setOf("one", "two", "three")
    println("contents of setExample: ${setExample}")

    val listExample = listOf("one", "two", "three")
    println("contents of listExample: $listExample")

    val mapExample = mapOf("one" to 1, "two" to 2, "three" to 3)
    println("contents of listExample: $mapExample")

    val listOfDummyExample = listOf(Dummy("one"), Dummy("two"), Dummy("three"))
    println("contents of listOfDummyExample: ${listOfDummyExample[0].aProperty}")
    listOfDummyExample[0].aProperty = "sdfjdskfjsk"
    println("contents of listOfDummyExample: ${listOfDummyExample[0].aProperty}")

    //this wont work
//    listOfDummyExample[0] = Dummy("another dummy")
//    println("contents of listOfDummyExample: ${listOfDummyExample[0].aProperty}")

    val aSet = setOf("a", "b", "c")
    val convertedList = aSet.toMutableList()
}