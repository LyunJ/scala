package lectures.part3fp

object AnonymousFunctions extends App {
// val doubler = new Function1[Int, Int] {
//   override def apply(x: Int) = x * 2
// }

  // anonymous function (LAMBDA)
//  val doubler = (x: Int) => x * 2
//  val doubler: Int => Int = x => x * 2

  // multiple params in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no params
  val justDoSomething: () => Int = () => 3

  println(justDoSomething) // function itself (it's not method)
  println(justDoSomething())// call

  //curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // MOAR syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a,b) => a + b
// 변수 하나에 할당된 underscore를 여러번 사용할 수 없다

  val superAdd = (x: Int) => (y: Int) => x + y
  println(superAdd(3)(4))
}
