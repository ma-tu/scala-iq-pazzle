package q11

import scala.annotation.tailrec

//4:05
object Main extends App {
  util.Properties.setProp("scala.time", "")

  @tailrec
  def fibAndDivideCheck(i: BigInt, j: BigInt, count: Int, result: List[BigInt]): List[BigInt] = {
    val num = i + j
    val str = num.toString
    val divisor = str.map(_.toString.toInt).sum
    if (result.length >= count) {
      result
    } else {
      if (num % divisor == 0) {
        fibAndDivideCheck(j, num, count, result :+ num)
      } else {
        fibAndDivideCheck(j, num, count, result)
      }
    }
  }

  val result = fibAndDivideCheck(1, 1, 11, List.empty)
  result.drop(5).foreach(println)
}
