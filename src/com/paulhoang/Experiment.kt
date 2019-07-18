package com.paulhoang

class Food(val aProperty: String) {
    val anotherProperty: String

    init {
        anotherProperty = "a value to let this compile"
    }

    fun someMethod(): Unit {
        println("the value of aProperty is ${aProperty}")
        println("the value of anotherProperty is ${anotherProperty}")
    }
}

fun main() {
    val blah: String

    val food = Food("a value for aProperty")

    println(food.someMethod())

}