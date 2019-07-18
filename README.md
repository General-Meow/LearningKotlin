### Learning Kotlin
###### Notes based off the Head First Kotlin Book

#### Chapter 2 - skip chapter 1 as its basic IDE stuff
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

#### Chapter 3
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

#### Chapter 4
- Like Java constructors run when you create an instance of a class
- Constructors are automatically created using the class definition paremeters
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

#### Chapter 5
- sdfds

#### Chapter 6
- sdfds

#### Chapter 7
- sdfds
