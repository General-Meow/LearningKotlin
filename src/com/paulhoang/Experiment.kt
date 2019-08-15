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

//null checks where if null check wont work as aProperty can be changed by anything
class ANullClass(var aProperty: String?) {
    fun printProperty() {
//        if(this.aProperty != null) {
//            println(this.aProperty.length)
//        }
    }
}


//null checks where if null check wont work as aProperty can be changed by anything
class SafeNullClass(var aProperty: String?) {
    fun printProperty() {
        println(this.aProperty?.length)
    }
}

class LetNullClass(var aProperty: String?) {
    fun printProperty() {
        this.aProperty?.let {
            println("length: ${it.length}")
        }
    }
}

class ElvisNullClass(var aProperty: String?) {
    fun printProperty() {
        println("length: ${this.aProperty?.length ?: 0}")
    }
}

fun main() {
    val blah: String

    //constructor
    val food = Food("a value for aProperty")
    println(food.someMethod())

    //inheritence and string interpolation
    val child = Child()
    println("The child is ${child.age} years old")

    //inheritence
    val anotherChild = AnotherChild(Integer(100))
    println("The anotherChild is ${anotherChild.age} years old")

    //inheritence with overridden method
    val someOtherChild = SomeOtherChild()
    println("The someOtherChild is ${someOtherChild.age} years old")

    //casting
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

    //data classes
    val myData = MyData("a value")
    myData.copy()

    //null
    val aNullVal: String? = null
    // println(aNullVal.length) this wont work unless you check for null first
    if(aNullVal != null) {
        println(aNullVal.length)
    }

    println("testing if null checks")
    //if null that cannot work
    val x = ANullClass(null)
    x.printProperty()

    //safe call, will print null
    val safe = SafeNullClass(null)
    safe.printProperty()

    //let safe
    val lets = LetNullClass(null)
    lets.printProperty()

    //elvis operator
    val elvis = ElvisNullClass(null)
    elvis.printProperty()
}