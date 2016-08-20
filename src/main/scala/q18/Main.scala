package q18

import scala.annotation.tailrec

object Main extends App {
  util.Properties.setProp("scala.time", "")

  def validate(last: Int, remain: Set[Int], squares: Set[Int]): Boolean = {
    if (remain.isEmpty) {
      squares.contains(last + 1)
    } else {
      remain
        .filter(r => squares.contains(last + r))
        .exists(r => validate(r, remain - r, squares))
    }
  }

  @tailrec
  def loop(n: Int): Int = {
    val squares = (2 to Math.sqrt(n * 2).floor.toInt).map(n => n * n).toSet
    if (validate(1, (2 to n).toSet, squares)) {
      n
    } else {
      loop(n + 1)
    }
  }

  println(loop(1))
}
