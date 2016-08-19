package q15

import scala.collection.mutable

object Main extends App {
  util.Properties.setProp("scala.time", "")

  val memo = mutable.Map.empty[(Int, Int, Int), Int]

  def move(a: Int, b: Int, jump: Int): Int = {
    memo.getOrElseUpdate((a, b, jump),
      (a, b) match {
        case (aa, bb) if aa == bb => 1
        case (aa, bb) if aa > bb => 0
        case _ =>
          (1 to jump).map(up => {
            (1 to jump).map(down => {
              move(a + up, b - down, jump)
            }).sum
          }).sum
      }
    )
  }

  //3777968[total 3729ms] memo化しなかった場合
  //3777968[total 148ms] memo化した場合
  println(move(0, 25, 4))
}
