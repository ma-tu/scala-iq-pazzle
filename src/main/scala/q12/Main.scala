package q12

import scala.annotation.tailrec

//5:16
object Main extends App {
  util.Properties.setProp("scala.time", "")

  @tailrec
  def recSqrt(num: Int, validate: (Double) => Boolean): Int = {
    if (validate(Math.sqrt(num))) {
      num
    } else {
      recSqrt(num + 1, validate)
    }
  }

  def allNumbersUse(s: String) = {
    val numbers = s.filter(_ != '.').take(10).map(_.toString.toInt)
    (0 to 9).forall(numbers.contains)
  }

  //整数
  val result1 = recSqrt(1, (d) => allNumbersUse(d.toString))
  println("整数あり:" + result1)

  //小数部
  val result2 = recSqrt(1, (d) => allNumbersUse(d.toString.substring(d.toString.indexOf('.'))))
  println("小数部のみ:" + result2)
}
