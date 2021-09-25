package lectures.park2oop

object Inheritance extends App {
  // single class inheritance
  // 한번에 하나만 상속 가능
  sealed class Animal {
    val creatureType = "wild"
    def eat = println("nomnom")
  }
  class Cat extends Animal{
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // construnctors
  class Person(name: String, age: Int){
    def this(name: String) = this(name,0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  //overwriting
  class Dog(override val creatureType: String) extends Animal {
//    override val creatureType = "domestic"
    override def eat ={
      super.eat
      println("crunch, crunch")
    }
  }

//  class Dog(dogType: String) extends Animal {
//    override val creatureType = dogType
//  }
  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // overriding vs overloading

  // super

  // preventing overrides
  // 1- use final member
  // 2- use final on the entire class
  // 3- seal the class = extend classes in THIS FILE, prevent extension in other file
}
