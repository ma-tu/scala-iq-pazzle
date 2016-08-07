package q1

/**
  * Created by matu on 2016/08/07.
  */
object Main extends App {

  def validCycleString(str: String): Boolean = str == str.reverse

  val result = Stream.range(10, Int.MaxValue)
    .find(n =>
      validCycleString(n.toString) &&
        validCycleString(n.toBinaryString) &&
        validCycleString(n.toOctalString)
    )

  result.foreach(n => println("10進数:" + n + "/2進数:" + n.toBinaryString + "/8進数:" + n.toOctalString))
}
