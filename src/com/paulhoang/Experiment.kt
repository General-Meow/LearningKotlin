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

//inheritence
open class Parent {

}

class Child: Parent() {
    val age = 10
}

open class AnotherParent(val age: Integer){}

class AnotherChild(anAgeToPassToChild: Integer): AnotherParent(anAgeToPassToChild) {}

open class SomeOtherParent {
    open var age = Integer(100)
    open fun blah() {}
}

class SomeOtherChild: SomeOtherParent() {
    var a = Integer(1)
    override var age = Integer(100)
    override fun blah() { }
}

//abstract and interfaces
interface Runnable {
    var aProperty: String

    fun blah()
    fun anotherBlah() { println("another blah") }
}

class Hmm: Runnable {
    override var aProperty = "aProperty defined in Hmm"
    override fun blah() { println("This is implemented in Hmm") }
}

//smart casting
interface Run {
    fun anInterfaceFun() { println("func from interface") }
}

class Blah: Run {
    fun aBlahFun() { println("func from class") }
}

data class MyData(val aProperty: String) {

}

fun main() {
    val blah: String

    val food = Food("a value for aProperty")

    println(food.someMethod())

    val child = Child()
    println("The child is ${child.age} years old")

    val anotherChild = AnotherChild(Integer(100))
    println("The anotherChild is ${anotherChild.age} years old")

    val someOtherChild = SomeOtherChild()
    println("The someOtherChild is ${someOtherChild.age} years old")

    val run: Runnable = Hmm()
    run.blah()
    run.anotherBlah()

    if(run is Runnable)
        println("run is a Runnable type")

    val b: Run = Blah()
//    this cannot happen because the b is a Run type
//    b.aBlahFun
    b.anInterfaceFun()
    if(b is Blah)
        b.aBlahFun()

    val myData = MyData("a value")
    myData.copy()

}