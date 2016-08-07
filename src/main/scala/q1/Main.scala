package q1

object Main extends App {
  def printTime(f: => Unit) = {
    val start = System.currentTimeMillis()
    f
    println((System.currentTimeMillis - start) + " msec")
  }

  def validCycleString(str: String): Boolean = str == str.reverse

  printTime {
    val result = Stream.range(10, Int.MaxValue).filter(_ % 2 == 1)
      .find(n =>
        validCycleString(n.toString) &&
          validCycleString(n.toBinaryString) &&
          validCycleString(n.toOctalString)
      )

    result.foreach(n => println("10進数:" + n + "/2進数:" + n.toBinaryString + "/8進数:" + n.toOctalString))
  }
}
