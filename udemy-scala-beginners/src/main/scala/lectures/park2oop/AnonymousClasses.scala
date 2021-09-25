package lectures.park2oop

object AnonymousClasses extends App {
  abstract class Animal {
    def eat: Unit
  }

//  class AnonymousClasses$$anon$ extends Animal {
//    override def eat: Unit = println("ahahah")
//  }
//
//  // anonymous class
//  val funnyAnimal: Animal = new AnonymousClasses$$anon$

  val funnyAnimal: Animal = new Animal {
        override def eat: Unit = println("ahahah")
      }

  println(funnyAnimal.getClass)

  class Person(name: String){
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help?")
  }

  val jim = new Person("Jim"){
    override def sayHi: Unit = println(s"Hi, my name is Jim, how can I be of service?")
  }



}
