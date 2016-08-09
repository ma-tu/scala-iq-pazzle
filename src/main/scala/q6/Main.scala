package q6

//8 minutes
object Main extends App {
  util.Properties.setProp("scala:time", "")

  def isReturnValue(startNum: Int, num: Int): Boolean = {
    if (num == startNum) {
      true
    } else if (num == 1) {
      false
    } else {
      if (num % 2 == 0) {
        isReturnValue(startNum, num / 2)
      } else {
        isReturnValue(startNum, num * 3 + 1)
      }
    }
  }

  val result =
    (2 to 10000 by 2)
      .filter(n => isReturnValue(n, n * 3 + 1))

  //result.foreach(println)
  println(result.size)
}
