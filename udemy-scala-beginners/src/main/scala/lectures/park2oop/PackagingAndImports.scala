package lectures.park2oop

import playground.{PrinceCharming, Cinderella => Princess}

import java.util.Date
import java.sql.{Date => SqlDate}


object PackagingAndImports extends App {
  // package members are accessible by their simple name
 val writer = new Writer("Daniel", "RockTheJVM", 2018)

  // import the package
  val princess = new Princess

  // packages are in hierarchy
  // matching folder structure

  // package object
  sayHello
  println(SPEED_OF_LIGHT)

  // imports
  val prince = new PrinceCharming

  val d = new Date
  val sqlDate = new SqlDate(2018,5,4)


  //default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???
}