package lectures.park2oop

object Object{
  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  object Person { // type + its only instance
    // "static"/"class" - level functionality
    val N_EYES = 2 // public static final int N_EYES = 2
    def canFly: Boolean = false

    // factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String) {
    // instance-level functionality
  }
  // COMPANIONS


  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = SINGLETON INSTANCE

  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john)

  val bobbie = Person(mary,john)

  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit
}
