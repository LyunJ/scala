package lectures.park1basics

object ValuesVariablesTypes extends App{
  val x: Int = 42
  println(x)

  //  x = 2
//  val은 재정의 불가


  val y = 42
  println(y)

  // compiler can infer types

  val aString: String = "hello"
  val anotherString = "goodbye"

  val aBoolean: Boolean = true
  val aChar: Char = 'a'

  val anInt: Int = x
  val aShort: Short = 4613
  val aLong: Long = 123123123112312312L
  val aFloat: Float = 2.0f  // f가 있어야 float로 인식함
  val aDouble: Double = 2.0

  // variables
  var aVariable: Int = 4

  aVariable = 5 // side effects
}
