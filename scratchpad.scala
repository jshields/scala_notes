
val helloWorld = List("Hello", "World").mkString("", ", ", "!")


// assigning anonymous function to a constant variable. Should essentially be the same as using `def`
val doubleIt = (x: Int) => x * 2
println(doubleIt(5))

// attempting to use postfix operator notation yields "value doubleIt is not a member of Unit"
// println expects to return Unit (like Java "void")
// But why doesn't operator notation work here? Postfix only valid for 0-arity methods. This is a function with an argument
// https://docs.scala-lang.org/style/method-invocation.html#postfix-notation
//println doubleIt(5)
assert(1.+(2) == 1 + 2)




val foo : List[Int] = List(1, 2, 3, 4, 5)

println("Expanded anonymous function syntax passed to foreach")
foo.foreach(x => println(x*2))

/*
Won't work
_ is used to create a partially applied function, attempting to multiply _ by two won't work,
because it's a lazy value / we don't know what to multiply by two at that point (?)

Shouldn't the short form anonymous function syntax work here since we are trying to pass 1 argument?
*/
// foo.foreach(_ => println(_*2))
// foo.foreach(_ : Int => println(_*2))
// foo.foreach(println(_*2))


// long form and short form work for method calls
val bar : List[String] = List("Foo", "Bar", "Baz")
println(bar.map(x => x.toLowerCase()))  // full syntax anonymous function
println(bar.map(_.toUpperCase()))  // short form anonymous function



// partially applied (?) anonymous addition function with two parameters passed as reduce function
// Are we using shorthand anonymous function or partially applied function or both?
val sum = foo.reduceLeft(_+_)
assert(sum == 15)
println(s"Sum of list items is $sum")


println("Fully named function with appropriate return type passed to foreach")
def printTimesTwo(x : Int) : Unit = println(x * 2)
foo.foreach(printTimesTwo)


println("partially applied println foreach")
// valid but the same as passing the println function directly
foo.foreach(println(_))

println("println function passed to foreach")
foo.foreach(println)
