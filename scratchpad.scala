
val helloWorld = List("Hello", "World").mkString("", ", ", "!")

// assigning anonymous function to a constant variable. Should be the same as using `def`
val doubleIt = (x: Int) => x * 2
println(doubleIt(5))

assert(1.+(2) == 1 + 2)

val foo : List[Int] = List(1, 2, 3, 4, 5)

foo.foreach(x => println(x*2))
// foo.foreach(println(_*2))
def printTimesTwo(x : Int) : Unit = println(x * 2)
foo.foreach(printTimesTwo)


val bar : List[String] = List("Foo", "Bar", "Baz")
println(bar.map(x => x.toLowerCase()))  // full syntax anonymous function
println(bar.map(_.toUpperCase()))  // short form anonymous function


val sum = foo.reduceLeft(_+_)
assert(sum == 15)
println(s"Sum of list items is $sum")


// valid but the same as passing the println function directly
foo.foreach(println(_))
foo.foreach(println)
