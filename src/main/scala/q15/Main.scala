package q15

object Main extends App {
  util.Properties.setProp("scala.time", "")

  def move(a: Int, b: Int, jump: Int): Int = {
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
  }

  println(move(0, 10, 4))
}
