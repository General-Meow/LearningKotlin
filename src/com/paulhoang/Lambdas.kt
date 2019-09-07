package com.paulhoang
typealias AddSeven = (Int) -> Int
typealias SillyString = String
fun main() {
    var myLambda = { x: Int -> x + 5}

    println(myLambda.invoke(5))
    println(myLambda(10))

    val anotherLambda: (Int) -> Int = { x: Int -> x + 10}
    println(anotherLambda(10))

    //using it
    val aLam: (Int) -> Int = {it + 5}
    println(aLam(11))

    aFunction(7, {it + 7})

    //type alias example
    addSevenFun(10, {it + 7})
}

fun aFunction(aNumber: Int, myLamda: (x: Int) -> Int ) {
    println("running the provided lamda with the value of aNumber $aNumber")
    println(myLamda(aNumber))
}

fun addSevenFun(param: Int, lambda: AddSeven) {
    println("running the lambda with the parameter")
    println(lambda.invoke(param))
    listOf(1,2,3).maxBy { selector: Int -> selector }
}