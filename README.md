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
- To use a setter you simply refer to the property and set it with `=` e.g. `anObject.property = aValueYouWantToSet`

```kotlin
class Food {

}

class Food {
    var aProperty: String

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
- When you define variables, they won't allow an initialization of null unless you define the type with a `?` e.g. `val x: String?` This means that the value can be a string OR null
- In order to use a variable that can be null, you must first check that the value isn't null, otherwise it will not compile
- You could be for `null` in a number of ways in kotlin
  - standard if check
    - if the compiler can guarentee that no other thread/code has access to the variable and that it cannot change in between the null check and its usage then this will work fine
  - the `?.` check "safe call operator" - `variableName?.propertyOrFunction`
    - this reads, if the left side (variableName) isn't null call/return the propertyFunction value
    - this operator can be chained, so `var?.var?.var?.function` can be done
  - the `?.let` check - like the safe call operator in that it behaves like a transaction but allows you to define a code block that is safe. 
    - Reads, if the left side is not null, 'lets' execute the block
    - Within the code block, you need to reference the left side varible as `it` 
  - the elvis operator `val x = y?.property ?: 'z'` 
    - This reads, return property if the y variable isn't null and the property isn't null otherwise return z 

```kotlin
class AClass(var aProperty: String?) {
    fun printProperty() {
        println(this.aProperty)
    }
}

fun ifCheck() {
    //if null check
    val value: String? = null
    //this wont work
    println(value.length)
    //this will work
    if(value != null) {
        println(value.length)
    }
}
```

```kotlin
class AClass(var aProperty: String?) {
    fun printProperty() {
        println(this.aProperty?.length)
    }
}

fun safeCall() {
    val safe = AClass(null)
    safe.printProperty()
}
```

```kotlin
class AClass(var aProperty: String?) {
    fun printProperty() {
        this.aProperty?.let {
            println(it.length)
        }
    }
}

fun letsCall() {
    val lets = AClass(null)
    lets.printProperty()
}
```

```kotlin
class AClass(var aProperty: String?) {
    fun printProperty() {
       println(aProperty?.length ?: 0)
    }
}

fun elvis() {
    val elvis = AClass(null)
    elvis.printProperty()
}
```

- To assert if a variable is not not null, you use the `!!` operator, e.g. `!!aNullVarible` will throw a NPE
- Try/catch/finally and throws all behave the same as Java, but can also be expressions, meaning they can return values
- Like the issue with checking for null, you can also do a `safe cast` with `as?`
- Unlike Java, Kotlin doesn't differentiate between checked/uncheck exceptions, it only uses unchecked, so no definitions in the method

```kotlin
fun tryCatchExpression(val param: String) {
    val result = try { param.toInt() } catch (e: Exception) { 0 }
    println(result)
}
```

#### Chapter 9 Collections
- You can create an array of null with `arrayOfNulls`
- Arrays have functions like `sum`, `average`, `sort`, `reverse`, `min`, `max`, `contains`
- Like Java, Kotlin has collections
- Set, List, Map are pretty much the same BUT they are immutable - they dont have methods like remove, add, clear etc
- To create them you use the methods, `setOf`, `listOf`, `mapOf`
- Even though the collections are immutable, the values within the collection are not. So you can change the properties of an object in a collection BUT you cant replace (reference) different objects
- To create mutable collections, use the methods: `mutableSetOf`, `mutableListOf`, `mutableMapOf`
- Mutable collections have methods such as, `add`, `remove`, `clear`, `addAll`, `removalAll`, `retainAll` etc
- The mutable collections are actually sub interfaces to the immutable types
- You can make copies of collections and convert them from immutable to mutable and vice versa by using methods `toMutableList()`, `toMutableSet()`, `toSet()`, `toList()`, `toMap()`, `toMutableMap()`
- Collections in Kotlin are like Java, for them to work correctly, the equals and hashcode methods need to be implemented properly
  - hashcodes are like labels for buckets, objects in a collection with the same hashcode will be stored in the same bucket
  - the hashcode algorithm should be able to generate numbers that are random/spread evenly so that searching is quick
  - the equals method need to be implemented properly such that its reflective a == b & b == a, its transitive a == b, b == c and c == a, and a == a
  - if 2 objects are equal, then they MUST return the same hashcode
  - but objects that are not equal can also (but doesnt have to) return the same hashcode
  - when searching/adding/removing from a collection, it first uses the hashcode to look into the correct bucket
  - then it looks at all the objects in the bucket and uses the equals method to see if the object already exists


#### Chapter 10 Generics
- Generics allows you to write consistent code that will work for multiple (restricted) types
- Generics are defined like in Java where you define a generic class with angled brackets `class MyGenericType<T> {}`
- When using a generic type, you do a mental `find and replace` on the generic part
- The standard for Generics is to use `T` for type, `E` for elements in collections and `K, V` for key values
- You can restrict the types you can use for a generic type by adding the type after the generics e.g. `Class MyGenericType<T: Pet> {}` this will allow only Pets and subtypes of Pets to be used
- Polymorphism works with Class types but not for generic types

```kotlin
open class Pet(val name: String){ }

open class Dog(name: String): Pet(name) { }

interface Retailer<T> {
    fun sell(): T
}

class PetRetailer: Retailer<Pet> {
    override fun sell() = Pet("a pet name")
}

class DogRetailer: Retailer<Dog> {
    override fun sell() = Dog("a dog")
}

fun method() {
    val petRetailer: Retailer<Pet> = PetRetailer()

    //This will not work as by default Generics are not polymorphic until you define the Generic type to be a covariant
    //With the out keyword interface Retailer<out T> {}
    val catRetailer:  Retailer<Pet> = DogRetailer() // <-- this will not compile
}
```

- If you want to use polymorphism on generic types in the variable type, you'll need to use `Covariant` and `Contravariant` types
- `Covariant` types allow you to use polymorphism on generic types.
- To create a covariant generic type, you simply need to add the `out` keyword in the type definition `class Blah<out T>`
- Like the keyword suggests, covariants only supports types outside, this means:
  - That the generic type can only be used outside of function/method parameters; so functions cannot accept parameter of the generic type
  - Constructors and function return types can be of that covariant types
  - Constructors when defining properties of a class can only be `val` as defining them as `var` will leave them open to change
  - The reason why you cannot use covariant types with function parameters, is because you dont want the chance in changing any internal properties types
```kotlin
class ACovariant<out T>(val property: T) { //this will work
    fun aFunction(param: T) //this will not work
    fun anotherFunction(): T //this will work
}
```

```kotlin
fun aFunction() {
    val retailer: Retailer<Pet> = DogRetailer() //this will now compile
}
```
- But what if you want to be able to assign a generic type that is a super type of the defined generic type?
  - What if you want to assign a salesman that can sell all types of pets rather just a Dog?
- You can use the opposite to `covariants` and use `contravariants` with the `in` keyword
```kotlin
class ContravariantRetailer<T: Pet>(val salesman: Salesman<T>) {
    fun sell() = salesman
}


class Salesman<in T: Pet> {
}

fun main() {
    //here we have the retailer being a dog retailer but the salemans can be a general purpose pet salesman
    //so the Pet type is a super type but its also a restricted super type of Pet
    val someOtherDogRetailer: ContravariantRetailer<Dog> = ContravariantRetailer(Salesman<Pet>())
    
    val someSalesman: Salesman<Dog>
}
```
- like when using `out` there are rules for `in`
  - You can use the generic type as parameter types for functions
  - You cannot use the in generic type as a return value
  - You cannot use the in generic type as a constructor or any val or var types
- You should consider using contravariance properly as all variables of type `Vet<Cat>` will be able to hold `Vet<Pet>`
  - In the above salesman example, all defined salesman types can hold a generic type that is a super type of Pet
  - We only want to do that in the context of a Retailer
  - To fix this issue, you can locally restrict contravariance to only where its required
  - This is done by moving the `in` keyword to only where its required (in the definition of the `Contravariant` type) 
```kotlin
class ContravariantRetailer<T: Pet>(val salesman: Salesman<in T>) {
    fun sell() = salesman
}

class Salesman<T: Pet> {
}

fun main() {
    //we can still set a salesman of type pet to a retailer of type dog
    val someOtherDogRetailer: ContravariantRetailer<Dog> = ContravariantRetailer(Salesman<Pet>())
    //but we cant do that globally now, this wont compile
    val dogSalesman: Salesman<Dog> = Salesman<Pet>()
}
```
- invariance is when you can only assign objects types to the variable type `val aList: List<Canine> = List<Canine>()`
  - this wont work, the invariant generic types aren't polymorphic `val aList: List<Canine> = List<Dog>()`
- covariance is when you can be polymorphic with the Generic type where the generic object type is a subtype of the defined variable `val aList: List<Canine> = List<Dog>()`
  - done with the `out` keyword 
- contravariance is when you can also be polymorphic with the Generic type where the generic onject type is a parent type of the defined varible `val aList: List<Canine> = List<Pet>()`
  - done with the `in` keyword
  
#### Chapter 11 Lamda's
- Like Javascript and Java 8+, Kotlin is a functional programming language
  - this means that Functions are also a first class citizen
  - this also means that like in OO languages, functions can be assigned to variables, passed as parameters and returned from functions
- A lambda looks like this `{ x: Int -> x + 1}`
  - The lambda is wrapped in curly braces
  - The first part of the definition the `x: Int` is the parameter list e.g. the input params to the lamda
  - The `->` is the seperator between the parameters and the main body of the lamda
  - The body `x + 1` is what runs when you `invoke` the lambda, the result of the last line is typically automatically returned 
- Lambdas have no name, they are anonymous
- A high order function is a function that takes another function (lambda) as a parameter
- The are two ways to invoke a lambda, using the invoke method or just calling it using the variables name with parenthesis
```kotlin
fun main() {
  val myLambda = {x: Int -> x + 1}
  //using the invoke method
  println(myLambda.invoke(5))
  //using parenthesis
  println(myLambda(10))
}
```
- Lambda's have types, although they are not like the typically types we're used to
  - The type is also known as the `function type`
  - They are are a combination of things and take the form `(params) -> return type`
  - The type of the lambda defined above is `(Int) -> Int`
  - Here's one for a lambda that adds two numbers `(Int, Int) -> Int`
  - They dont need to take any params nor return anything, in that case its `() -> Unit`
- The Kotlin compiler will infer the type of a lambda so you don't need to define it when assigning it to a variable
- If you want, you can define the lambda type as so: `val anotherLambda: (Int) -> Int = { x: Int -> x + 10}`
- For lambda's that take a single parameter, you can remove the parameter definition and referred to it as `it` in the body (this will only work if the compiler can infer the parameter type)
  - `val aLam: (Int) -> Int = {it + 5}`
- Just like when assigning objects to variables, the compiler cares very much about lambda types, so you wont be able to assign a lambda with different types
- Just like objects, you can assign a lambda to the type `Any`
- Defining a function that takes a lambda looks like `fun aFunction(aNumber: Int, myLamda: (x: Int) -> Int )`
  - Don't forget the name that your assigning the lambda to
  - Running this function will look like: `aFunction(7, {it + 7})`
- There is an alternative syntax when running a function with a lambda as a parameter. It looks like this for the above example `aFunction(7) {it + 7}`
  - Here the lambda is moved outside of the parenthesis
  - This alternative syntax is only possible if the last parameter is a lambda
- There is also another alt syntax for functions that just take a single lambda as a parameter
  - If the aFunction took only a lambda, it could be called like: `aFunction {it + 7}`
- Lamdba's could also be returned from functions e.g. `fun aRet(): (Int) -> Int {...}`
- Using lambda's can be quite hard to read, to get around this, you can use `type alias`
  - A `type alias` allows you to assign an alternative name to an existing type
  - Type alias must be defined outside of a function, doing so within a function will not compile
  - You can type alias Generic types or even the standard types `typealias NumbArr = Array<Int>` or `typealias SillyString = String`
```kotlin
typealias AddSeven = (Int) -> Int
fun addSevenFun(param: Int, lambda: AddSeven) {
    println("running the lambda with the parameter")
    println(lambda.invoke(param))
}
```

#### Chapter 12 OOTB Higher Order Functions
- Kotlin comes with a large amount of higher order functions
- Higher order functions allow you to generically write code and then have it be provided specialist code to execute within it
- Some of the most useful higher order functions are in the `Collections` package
- Here are some of the functions
  - min    - Returns the smallest value of a collection, requires the items to have some ordering
  - minBy  - Return the smallest value using the provided lambda, the lambda must return the property/criteria to compare by. Takes a single parameter of the list type
  - max    - Return the largest value of a collection, requires the items to have some ordering
  - maxBy  - Return the largest value using the provided lambda, the lambda must return the property/criteria to compare by. Takes a single parameter of the list type 

```kotlin
fun examples() {
    val numbers = listOf(1, 2, 3, 4, 5)
    val smallestNumber = numbers.min();
    val largestNumber = numbers.max();
    val sumOfAll = numbers.sumBy { it }
    
    val hampsters = listOf(Hampster("Joe", 10), Hampster("Bob", 5), Hampster("Berry", 20), Hampster("Smiles", 3))
    val smallestHampster = hampsters.minBy { it.size };
    val largesttHampster = hampsters.maxBy { it.size };
}
```
  - sumBy       - takes a lambda that returns the sum of all items in the list. works on Ints
  - sumByDouble - takes a lambda that returns the sum of all items in the list. works on Doubles
  - filter      - takes a lambda that must return a boolean (its a predicate). if true then the item is returned in the resultant list
  - filterTo    - like filter but adds the items to an existing list
  - filterIsInstance - returns a list of items that are of a certain class type
  - filterNot   - negates the predicate to return a list of it items that don't match the predicate
  - map         - returns a list of the type returned in the lambda
  - mapTo       - map to an existing list
  - mapNotNull
```kotlin
    val largestHampsters = hampsters.filter { it.size > 10 }
    println("large hampsters $largestHampsters")
    val hampsterSizes = hampsters.map { it.size }
    println("all sizes $hampsterSizes")
```
- You can chain higher order functions together

```kotlin
    val sumOfAllHampsterSizes = hampsters.map { it.size }.sum()
    println("sum of all sizes $sumOfAllHampsterSizes")
```
  - forEach    - Just like a for loop, works on lists, sets, arrays and maps. useful if your already filtering, mapping on a collection
- Closures
  - Lambda's have access to variables that have been defined outside the lambda
  - When a lambda uses a value outside of the lambda, we say that its captured the variable
  - Closure values can be updated (which isn't possible in java)
- Splitting collections into groups
  - groupBy    - takes a lambda returning the criteria in which to group by, this return type then becomes the key of the created map. The values are then a list of the original list type but grouped by the key

```kotlin
    val musicCollection = listOf(Song("Gold Digger", "RnB", 10.0), Song("Hey Ya!", "Pop", 5.99),
        Song("Steal My Sunshine", "Pop", 1.0), Song("In too deep", "Alt", 2.99), Song("All the small things", "Alt", 4.99))

    val categoriesToSongs = musicCollection.groupBy { it.category }
    println("music grouped by category $categoriesToSongs")
```
- fold - a function that starts with an initial value and with that initial value, runs a lambda against the items in the list, saving the running result
- foldRight - the same as fold but iterate through the list from last item to first
- reduce - list fold but uses the first item in the list as the first item rather than providing an initial value
- reduceRight - list reduce but iterates the list in reverse

```kotlin
    val words = listOf("A", "list", "of", "words")
    val wordsFolded = words.fold("") { runningResult, item -> "$runningResult$item " }
    println("all words joined: '$wordsFolded'")
```
