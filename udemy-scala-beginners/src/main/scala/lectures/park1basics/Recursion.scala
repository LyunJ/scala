package lectures.park1basics

import lectures.park1basics.Function.aRepeatedFunction

import scala.annotation.tailrec

object Recursion extends App {
////  @tailrec
//  def factorial(n: Int): Int =
//    if(n <= 1) 1
//    else {
//      println("Computing factorial of " + n + " - I first need factorial of " + (n - 1))
//      val result = n * factorial(n - 1)
//      println("Computed factorial of " + n)
//      result
//    }
//
//  println(factorial(10))
//
//  def anotherFactorial(n: Int): BigInt = {
//    @tailrec // tail recursion인지 체크해주는 annotation
//    def factHelper(x: Int, accumulator: BigInt): BigInt =
//      if(x <= 1) accumulator
//      else factHelper(x - 1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression
//
//    factHelper(n,1)
//  }
//  println(anotherFactorial(5000))

  // WHEN YOU NEED LOOPS, USE _TAIL_RECURSION

  /**
   * 1. Concatenate a string n times
   * 2. IsPrime function tail recursive
   * 3. Fibonacci function, tail recursive
   */

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString,n-1)
  }
  def concatString(n: Int, aString: String): String = {
    @tailrec
    def concatHelper(count: Int, result: String, addString: String): String = {
      if (count <= 1) result
      else concatHelper(count - 1, result + addString, addString)
    }
    concatHelper(n,aString, aString)
  }
  println(concatString(10,"hello"))

  def isPrime(n : Int): Boolean = {
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean = {
      if(!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)
    }
    isPrimeTailrec(n / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(629))

  def fibonacci(n: Int): Int = {
    def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int =
      if(i >= n) last
      else fiboTailrec(i + 1, last + nextToLast, last)
    if (n <= 2) 1
    else fiboTailrec(2, 1, 1)
  }

  println(fibonacci(8))
}
