### Learning Kotlin
###### Notes based off the Head First Kotlin Book

#### Chapter 2 - Variables - skip chapter 1 as its basic IDE stuff
- variables are defined with `val` and `var`
- `val` variables can only be initialized once, while `var` can be reassigned many times
- The type is inferred by the type you initialize it with
- You can optionally define the type with `val var_name: TYPE` e.g. `val blah: String`
- Like java, variables are just references to variables on the heap
- Kotlin doesn't have primitive types like Java only Object types: Byte, Short, Int, Long, Float, Double, String, Boolean and Char
- You can only assign a variable to a compatible type of Object
- Arrays can be created using the function `arrayOf(..)`
- Items of an array can be accessed with `[]` e.g. `myArray[0]`
- You can inject a variables value into a String using String templates. e.g. `"a varianle can be accessed ${var_name}""`
- for loops are done with in `for(x in arr)` and you can use `steps` 
```kotlin
val notInit: String
var aVar: String = "a string"
val aVal = "another string"
```

```kotlin
var anArray: ArrayList<Integer>
var aList = arrayOf(1,2,3)
println(aList[0])
val size = aList.size
println("size of array is ${size}")
```

#### Chapter 3 - functions
- Functions are used to group functionality together and keep things organised, it also helps with reuse and composibility
- Like Java they can have parameters as well as return types
- If a function doesn't return anything, you can optionally define it with a return type of `Unit`
- The `readLine` function takes input from the standard input and returns a String, redirection can happen and the input maybe from something else, in that case it will return null when theres no more input

```kotlin
fun aFunctionWithNoParams() { }

fun aFunctionWithParams(blah: String, num: Integer) { }

fun noReturnButDefined(): Unit { }

fun retTypeDefined():String {return ""}

fun noReturnAgain() { }
```

#### Chapter 4 - Classes and properties
- Like Java constructors run when you create an instance of a class
- A primary constructor is automatically created using the class definition parameters
- Secondary constructors are manually defined using the `constructor` keyword and must first call the primary constructor using `this(x,y,z)`

```kotlin
class AClass(val param: String) {
  constructor(anotherParam: String) {
    this(anotherParam)
    //do some stuff
  }
}
```

- In order to define class properties, you either need to define the class parameters with `val` or `var` (for the constructor) or define them in the class body
- Initializer blocks are like static blocks in Java, these run in the order of appearance in the class and are used to define code that initialize class properties
- Initializers run after running the constructor
- Getters and setters are automatically provided for properties; both for `var` type properties and only getters for `val` types
- You can manually define and customise the getters and setters straight after defining the property
- Getters and setter methods are `get()` and `set(value)`
- When defining a setter/getter, you must not refer to the property your getting/setting. this is because you'll cause a recursive call and cause a stack overload

```kotlin
class Food {

}

class Food {
    var aPropery: String

    init {
        aProperty = "sdfdsf"
    }
}

//constructor is generated using the class parameters
class Food(val aProperty: String)
  val anotherProperty: String
  
  init {
    anotherProperty = "dffsfs"
  }

//defined getter setters
class Food {
  var aProperty = "a val"
    get() = aProperty
    set(value) {
        field = value
      }
}

```

#### Chapter 5 - Inheritence
- To extend a class you use colon then the class name with parenthesis for the constructor with any required parameters 
- For a class to be inheritable, you need to define it with the `open` keyword - this corresponds to the `Design and document for inheritence or else prohibit it` from the Effective Java book
- `open` is not only for class definitions, you need to use it for properties and methods too
- If the superclass has a primary constructor, you must provide those arguments in the class definition
- Properties that have been marked as open do not need to be overriden, it just gives the option to `override`
- When overriding a property, you must use the `override` keyword and use types that are compatible with the overridden type (in other words the return type of the overriden function must be the same or more specific)
- Functions and properties stay open (when they are defined as open) until the get defined at `final`
- Polymorthism means many forms, it allows references to many objects that have different implementations of functions.
- When calling a property or function on an object, the compiler will travel from the bottom to top looking for the most specific implementation (looking at all the `overriden` ones)
- If you redefine a property from the parent thats `open`, if you define it again without the `override` then it wont compile
- You cannot hide properties like in java where you define a property with the same name, it doesnt compile
-

```kotlin
open class Parent { }

class Child: Parent() { }

open class AnotherParent(val age: Integer) { }

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

```

#### Chapter 6 - Abstract Classes and Interfaces
- An `abstract` class is a class in the class heiarchy tree that cannot be instantiated
- You use abstract classes to stop applications/devs from instantiating types that dont make sense
- Abstract classes can contain both implementated functions and abstract functions
- Abstract functions are defined with the `abstract` keyword and no function body
- The first concreate class to inherit from a abstract class `MUST` implement all functions (be overridden) that are still `abstract`
- Abstract properties/classes are `open` by default
- Interfaces allow you to define behaviour but it cannot hold intialized state(properties)
- Interfaces can hold both abstract and concrete methods
- By default properties and functions are abstract in Interfaces
- Like Java classes can only have one Parent while implement multiple interfaces
- A class implementing an interface is like a class extending a parent class but without the parenthesis (as there are no interface constructors)
- A class extending a class and implementing multiple interfaces are done by separeting them with commas `class A: B(), C, D { }`
- A subclass can run/access parent functions with the syntax `super<PARENT>.parentFunction`
- To check a reference is a type of a class or interface, use the `is` operator `aVal is MyClass`
- The `is` operator does a `smart cast` such that once you check if a variable `is` a certain instance of a type, then in all code after that variable is casted and therefore all properties & functions on that type is accessible
- `!is` is also possible

```kotlin
interface Runnable {
    var aProperty: String

    fun blah()
    fun anotherBlah() { println("another blah") }
}

class Hmm: Runnable {
    override var aProperty = "aProperty defined in Hmm"
    override fun blah() { println("This is implemented in Hmm") }
}

fun main(){
val run: Runnable = Hmm()
    run.blah()
    run.anotherBlah()
    
    if(run is Runnable)
        println("run is a Runnable type")
}
```

```kotlin
//is operator

interface Run {
  fun anInterfaceFun() { println("func from interface") }
}

class Blah: Run {
  fun aBlahFun() { println("func from class") }
}
fun main() {

    val b: Run = Blah()
//    this cannot happen because the b is a Run type
//    b.aBlahFun
    b.anInterfaceFun()
    if(b is Blah)
        b.aBlahFun()
}
```
#### Chapter 7 Data classes, equality, Any, overloading, deconstructing, copying, default values
- Java has the Object type that all classes extend, Kotlin has the `Any` class
- The `Any` class like java has implementations for equals, toString, hashcode etc
- Like Java POJOs, Kotlin has data classes that represent data
- to define a data class, simply prepend the keyword `data` in the class definition

```kotlin
data class SomeData(val property1: String, val property2: Int) {
    val property3: String //this property is not included in any overridden methods (equals, hashcode, toString etc)
    
    constructor(var someOther: String) {
    this("", 2);
    property3 = someOther
    }
}
```
- Data classes automatically override the equals, hashcode and toString methods
- Data classes MUST have a constructor with at LEAST one property (otherwise it wont make sense)
- The parameters of the Data class parameters MUST be declared `val` or `var`
- Data classes must not be `open` or `abstract`
- The equals method is overridden to look for property based equality, so it will include all properties defined in the class definition NOT the ones defined in the class body
- The `==` operator calls the `equals` method on the class and by default (the inherited one from Any) is defined as same instance (object on heap) equality
- So normal classes will need to override the `equals` method to get any real meaning out of it, while data classes already implemented sensibly
- As the `==` operator can change depending on the equals implementation, if you want to check for object instance equality, Kotlin has the `===` operator to do that  
- Overloading is just like java, you have to at least change the parameters and optionally the return type
- There are a couple of ways to deconstruct objects to its properties
  - use the componentN method to generically refer to properties that have been defined (in order) in the (class)data. It starts from 1 so `obj.component1()`
  - use destructure declaration to break all the components of a type into it individual components `val (property1, property2) = obj` this will create val property1 and property2 that will hold the first and second properties of the obj type  
- When using data classes, its heavily recommended that you make it as immutable as possible, this mean you should basically make everything `val`
- If you need to change a value of a data object, you basically need to `copy` function that data types have, this function can take named arguments that change the value of properties before copying

```kotlin
data class MyDataClass(val blah: String, val anotherProp: String, val thirdOne: String) {}

fun main(args: Array<String>) {
    val data1 = MyDataClass("value")
    val data2 = data1.copy(anotherProp = "zzzzz", thirdOne = "asdsad")
}
```
- Constructors and functions can have default values for parameters, this makes using them easier as you dont need to always provide the parameters if the default ones are ok
  - there are 3 ways to use functions with default parameters
  - provide all the params, which will override any default params
  - provide parameters in order of definition, any parameters left out will use default values (you cannot skip parameters)
  - provide parameters in a named format, this will allow you to provide parameters in any order
  
```kotlin
fun aFunction(param1: String, param2: String, param3: Int = 100, param4: Short = 1, param5: String = "I'm a default value") {
}

fun main(args: ArrayList<String>) {
    
    //provide all params - overriding any default 
    aFunction("a param 1", "another param 2", 5, 2, "not the default value")
    
    //provide parameters omitting some of the default ones
    aFunction("a param 1", "another param 2", 5)

    //provide only the mandatory params, all the default ones will be used
    aFunction("a param 1", "another param 2")

    //named parameters
    aFunction(param1 = "a param1", param3 = 30, param2 = "out of order works!")
}
```

#### Chapter 8 Null and null safety
- Just like Java, Kotlin has `null` and NullPointerExceptions (although it is harder to cause NPEs)
- `null` is an absence of a value
- Normally 





