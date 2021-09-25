package lectures.park1basics

object Expressions extends App{
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3
  println(aConditionedValue)
  println(if(aCondition) 5 else 3)
  println(1+3)

  var i = 0
  val aWhile = while (i<10){
    println(i)
    i+=1
  }
  // never write this again

  // EVERYTHING in scala is an Expression
  var aVariable = 2
  val aWeirdValue = (aVariable = 3) // Unit == void
  println(aWeirdValue)

  // Code blocks
  val aCodeBlock = {
    val y=2
    val z = y + 1

    if(z > 2) "hello" else "goodbye"
  }

  // 1. difference between "hello world" vs println("hello world")

  val someValue = {
    2 < 3
  }

  println(someValue)
  val someOtherValue = {
    if (someValue) 239 else 986
    42
    val a = 10
  }
  println(someOtherValue)
}
