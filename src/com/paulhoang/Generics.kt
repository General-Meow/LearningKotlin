package com.paulhoang

open class Pet(val name: String){ }

open class Dog(name: String): Pet(name) { }

class Husky(name: String): Dog(name) { }

class MyDogsGenerics<T: Dog>() {
    fun someRandomMethod(param: T) {
        println(param)
    }
}

class Car(val topSpeed: Int) {}

abstract class Retailer<out T>(val property: T) {
    abstract fun sell(): T
}

class PetRetailer(prop: Pet): Retailer<Pet>(prop) {
    override fun sell(): Pet = Pet("a pet name")
}

class DogRetailer(prop: Dog): Retailer<Dog>(prop) {
    override fun sell(): Dog {
        return Dog("a dog")
    }
}

class CarRetailer(prop: Car): Retailer<Car>(prop) {
    override fun sell(): Car {
        return Car(80)
    }
}

class ContravariantRetailer<T: Pet>(val salesman: Salesman<T>) {
    fun sell() = salesman
}


class Salesman<in T> {
}

class RestrictedContravariantRetailer<T: Pet>(val salesman: RestrictedSalesman<in T>) {
    fun sell() = salesman
}


class RestrictedSalesman<T: Pet> {
}



fun main(args: Array<String>) {

    val myGenericsVariable = MyDogsGenerics<Dog>()

    //the following wont work, as the class is restricted to Dog types and below
    //myGenericsVariable.someRandomMethod(Pet("a Name"))

    myGenericsVariable.someRandomMethod(Dog("a Dog"))
    myGenericsVariable.someRandomMethod(Husky("a Husky"))

    val petRetailer: Retailer<Pet> = PetRetailer(Pet("pet name"))

    //This will not work as by default Generics are not polymorphic until you define the Generic type to be a covariant
    //With the out keyword interface Retailer<out T> {}
    val dogRetailer:  Retailer<Pet> = DogRetailer(Dog("dog name"))
    dogRetailer.property
    val carRetailer: Retailer<Car> = CarRetailer(Car(100))

    //contravariance
    val anotherDogRetailer: ContravariantRetailer<Pet> = ContravariantRetailer(Salesman<Pet>())
    println(anotherDogRetailer.sell())
    //here we have the retailer being a dog retailer but the salemans can be a general purpose pet salesman
    //so the Pet type is a super type but its also a restricted super type of Pet
    val someOtherDogRetailer: ContravariantRetailer<Dog> = ContravariantRetailer(Salesman<Pet>())
    //uhoh, we dont want to globally set pet salesman to dog salesman... we only want to do that in the context of a retailer
    val someSalesman: Salesman<Dog> = Salesman<Pet>()

    //we can still set a pet salesman to a dog retailer
    val restrictedRetailed: RestrictedContravariantRetailer<Dog> = RestrictedContravariantRetailer<Dog>(RestrictedSalesman<Pet>())
    //but we cant do that globally now, this wont compile
    //val dogSalesman: RestrictedSalesman<Dog> = RestrictedSalesman<Pet>()

}