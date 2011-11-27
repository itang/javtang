/**
 * Demo
 */
object Main extends App {
  implicit def anyw(x: Any) = new {
    def println() {
      Console.println("" + x)
    }
  }

  implicit def iw(x: Int) = new {
    def times(proc: => Any) {
      var i = 0
      while (i < x) {
        proc
        i += 1
      }
    }
  }

  println("Hello, World!")
  "Welcome to xsbt 0.10.0".println()
  (10).times(println("Hello, scala"))
  "hello".headOption match {
    case Some(c) => println("first char is " + c)
    case None => println("None")
  }
  println("hello"(1))
}