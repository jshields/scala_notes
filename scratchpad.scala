val helloWorld = List("Hello", "World").mkString("", ", ", "!")


// assigning anonymous function to a constant variable. Should essentially be the same as using `def`
val doubleIt = (x: Int) => x * 2
println(doubleIt(5))

// attempting to use postfix operator notation yields "value doubleIt is not a member of Unit"
// println expects to return Unit (like Java "void")
// But why doesn't operator notation work here?
//println doubleIt(5)
assert(1.+(2) == 1 + 2)


val foo : List[Int] = List(1, 2, 3, 4, 5)


println("Expanded anonymous function syntax passed to foreach")
foo.foreach(x => println(x*2))


/*
Won't work
_ is used to create a partially applied function, attempting to multiply _ by two won't work,
because it's a lazy value / we don't know what to multiply by two at that point (?)
*/
// foo.foreach(_ => println(_*2))
// foo.foreach(_ : Int => println(_*2))



// partially applied addition function with two parameters passed as reduce function
val sum = foo.reduceLeft(_+_)
assert(sum == 15)
println(s"Sum of list items is $sum")


// This works
println("Fully named function with appropriate return type passed to foreach")
def printTimesTwo(x : Int) : Unit = println(x * 2)
foo.foreach(printTimesTwo)


println("partially applied println foreach")
// valid but the same as passing the println function directly
foo.foreach(println(_))

println("println function passed to foreach")
foo.foreach(println)


// Using _ as `x => x`
val bar : List[String] = List("Foo", "Bar", "Baz")
println(bar.map(x => x.toLowerCase()))
println(bar.map(_.toUpperCase()))
