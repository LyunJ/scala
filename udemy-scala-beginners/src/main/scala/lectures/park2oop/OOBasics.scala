package lectures.park2oop

//object OOBasics extends App {
//  val person = new Person("John",26)
//  println(person.age)
//}
//
//class Person(name: String, age: Int) // constructor
//
//// class parameters are NOT FIELDS

//object OOBasics extends App {
//  val person = new Person("John",26)
//  println(person.age)
//}
//
//// constructor
//class Person(name: String, val age: Int)

object OOBasics extends App {
  val person = new Person("John",26)
  println(person.x)
  person.greet("Daniel")
  person.greet()
  val counter = new Counter
  counter.increment.increment.increment.print
  counter.increment(10).print
}

// constructor
class Person(name: String, val age: Int) {
  //body
  val x = 2

  println(1 + 3)

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple contructors
  def this(name: String) = this(name,0)


}

// class parameters are NOT FIELDS

class Writer(firstName: String, surname: String,val year: Int){
  def fullName(): String = firstName + surname
}

class Novel(name: String, yor: Int, author: Writer){
  def authorAge(): Int = author.year
  def isWrittenBy(author: Writer): Boolean = author == this.author
  def copy(nyor: Int): Novel = {
    new Novel(this.name, nyor, this.author)
  }
}

class Counter(val num: Int = 0){
  def currentCount(): Int = this.num
  def increment(): Counter = {
    println("incrementing")
    new Counter(this.num + 1)
  }
  def decrement(): Counter = {
    println("decrementing")
    new Counter(this.num - 1)
  }
  def increment(n: Int): Counter = {
    if (n <= 0) this
    else increment.increment(n-1)
  }
  def decrement(n: Int): Counter =
    if (n <= 0) this
    else decrement.decrement(n-1)

  def print = println(num)
}