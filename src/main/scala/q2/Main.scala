package q2

object Main extends App {
  util.Properties.setProp("scala.time", "")

  val opsList = List(
    List("*", "*", "*"),
    List("", "*", "*"),
    List("*", "", "*"),
    List("*", "*", ""),
    List("", "", "*"),
    List("*", "", ""),
    List("", "*", "")
  )

  def calc(calculated: Int, right: String, display: String, str: String, ops: List[String]): (Int, String) = {
    if (ops.isEmpty) {
      val d = display + str.head
      (calculated * (right + str.head).toInt, d)
    } else {
      val d = display + str.head + ops.head
      ops.head match {
        case "" =>
          calc(calculated, right + str.head, d, str.tail, ops.tail)
        case "*" =>
          calc(calculated * (right + str.head).toInt, "", d, str.tail, ops.tail)
      }
    }
  }

  val calculatedList = for (n <- 1000 to 9999; p <- opsList)
    yield {
      val c = calc(1, "", "", n.toString, p)
      (n, c._1, c._2)
    }

  val result = calculatedList.withFilter { case (n, v, _) =>
    n.toString == v.toString.reverse
  }.map { case (_, _, d) => d }

  println(result.mkString(","))
}
