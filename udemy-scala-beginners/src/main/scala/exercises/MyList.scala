//package exercises
//
//abstract class MyList[+A] {
//  def head: A
//  def tail: MyList[A]
//  def isEmpty: Boolean
//  def add[B >: A](element: B): MyList[B]
//  def printElements: String
//  // polymorphic call
//  override def toString: String = "[" + printElements + "]"
//
//  def map[B](transformer: MyTransformer[A,B]): MyList[B]
//  def flatMap[B](transformer: MyTransformer[A,MyList[B]]): MyList[B]
//  def filter(predicate: MyPredicate[A]): MyList[A]
//
////  def ++(list: MyList[A]): MyList[A] ???
//  //concatenation
//  def ++[B >: A](list: MyList[B]): MyList[B]
//}
//
//case object Empty extends MyList[Nothing]{
//  def head: Nothing = throw new NoSuchElementException
//  def tail: MyList[Nothing] = throw new NoSuchElementException
//  def isEmpty: Boolean = true
//  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
//  override def printElements: String = ""
//
//  def map[B](transformer: MyTransformer[Nothing,B]): MyList[B] = Empty
//  def flatMap[B](transformer: MyTransformer[Nothing,MyList[B]]): MyList[B] = Empty
//  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty
//
//  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
//}
//
//case class Cons[+A](h: A, t: MyList[A]) extends MyList[A]{
//  def head: A = h
//  def tail: MyList[A] = t
//  def isEmpty: Boolean = false
//  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
//  def printElements: String =
//    if(t.isEmpty) "" + h
//    else h + " " + t.printElements
//
//  def filter(predicate: MyPredicate[A]): MyList[A] =
//    if(predicate.test(h)) new Cons(h, t.filter(predicate))
//    else t.filter(predicate)
//
//
//  def map[B](transformer: MyTransformer[A,B]): MyList[B] =
//    new Cons(transformer.transform(h), t.map(transformer))
//
//  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)
//
//  def flatMap[B](transformer: MyTransformer[A,MyList[B]]): MyList[B] =
//    transformer.transform(h) ++ t.flatMap(transformer)
//}
//
//trait MyPredicate[-T]{
//  def test(elem: T): Boolean
//}
//
//trait MyTransformer[-A,B]{
//  def transform(elem: A): B
//}
//
//object ListTest extends App{
//  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
//  val cloneListOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
//  val anotherlistOfIntegers: MyList[Int] = new Cons(4, new Cons(5,Empty))
//  val listOfStrings: MyList[String] = new Cons("hello", new Cons("Scala", Empty))
//
//  println(listOfIntegers.add("hello").add(5).toString)
//  println(listOfStrings.toString)
//
//  println(listOfIntegers.map(new MyTransformer[Int,Int] {
//    override def transform(elem: Int): Int = elem * 2
//  }).toString)
//
//  println(listOfIntegers.filter(new MyPredicate[Int] {
//    override def test(elem: Int): Boolean = elem % 2 == 0
//  }).toString)
//
//  println((listOfIntegers ++ anotherlistOfIntegers).toString)
//  println(listOfIntegers.flatMap(new MyTransformer[Int, MyList[Int]] {
//    override def transform(elem: Int): MyList[Int] = new Cons(elem, new Cons(elem + 1, Empty))
//  }).toString)
//
//  println(listOfIntegers == cloneListOfIntegers)
//}


package exercises

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  // polymorphic call
  override def toString: String = "[" + printElements + "]"

  //higher-order function
  def map[B](transformer: A => B): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]

  //  def ++(list: MyList[A]): MyList[A] ???
  //concatenation
  def ++[B >: A](list: MyList[B]): MyList[B]

  // hofs
  def foreach(f: A => Unit): Unit
  def sort(compare: (A, A) => Int): MyList[A]
  def zipWith[B,C](list: MyList[B], zip:(A, B) => C): MyList[C]
  def fold[B](start: B)(operator: (B, A) => B): B
}

case object Empty extends MyList[Nothing]{
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  override def printElements: String = ""

  def map[B](transformer: Nothing => B): MyList[B] = Empty
  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  // hofs
  def foreach(f: Nothing => Unit): Unit = ()
  def sort(compare: (Nothing, Nothing) => Int) = Empty
  def zipWith[B,C](list: MyList[B], zip:(Nothing, B) => C): MyList[C] =
    if (!list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else Empty
  def fold[B](start: B)(operator: (B, Nothing) => B): B = start
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A]{
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
  def printElements: String =
    if(t.isEmpty) "" + h
    else h + " " + t.printElements

  def filter(predicate: A => Boolean): MyList[A] =
    if(predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)


  def map[B](transformer: A => B): MyList[B] =
    new Cons(transformer(h), t.map(transformer))

  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

  def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)

  // hofs
  def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] = {
      if (sortedList.isEmpty) new Cons(x, Empty)
      else if (compare(x, sortedList.head) <= 0) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x, sortedList.tail))
    }
    val sortedTail =  t.sort(compare)
    insert(h, sortedTail)
  }

  def zipWith[B,C](list: MyList[B], zip:(A, B) => C): MyList[C] =
    if (list.isEmpty) throw new RuntimeException("Lists do not have the same length")
    else new Cons(zip(h, list.head), t.zipWith(list.tail, zip))

  /*
  [1,2,3].fold(0)(+) =
  [2,3].fold(1)(+) =
  [3].fold(3)(+) =
  [].fold(6)(+) =
  6
   */
  def fold[B](start: B)(operator: (B, A) => B): B = {
    t.fold(operator(start, h))(operator)
  }
}

//trait MyPredicate[-T]{
//  def test(elem: T): Boolean
//}
//
//trait MyTransformer[-A,B]{
//  def transform(elem: A): B
//}

object ListTest extends App{
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val cloneListOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherlistOfIntegers: MyList[Int] = new Cons(4, new Cons(5,Empty))
  val listOfStrings: MyList[String] = new Cons("hello", new Cons("Scala", Empty))

  println(listOfIntegers.add("hello").add(5).toString)
  println(listOfStrings.toString)

  println(listOfIntegers.map(elem => elem * 2).toString)

  println(listOfIntegers.filter(elem => elem % 2 == 0).toString)

  println((listOfIntegers ++ anotherlistOfIntegers).toString)
  println(listOfIntegers.flatMap(elem => new Cons(elem, new Cons(elem + 1, Empty))).toString)

  println(listOfIntegers == cloneListOfIntegers)

  listOfIntegers.foreach(println)
  println(listOfIntegers.sort((x,y) => y - x))
  println(anotherlistOfIntegers.zipWith[String,String](listOfStrings, _ + "-" + _))

  println(listOfIntegers.fold(0)(_ + _))

  val combinations = for {
    n <- listOfIntegers
    string <- listOfStrings
  } yield n + "-" + string
  println(combinations)
}