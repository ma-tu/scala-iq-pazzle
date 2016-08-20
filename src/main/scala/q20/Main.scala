package q20

object Main extends App {
  util.Properties.setProp("scala.time", "")

  val numbers = List(1, 14, 14, 4, 11, 7, 6, 9, 8, 10, 10, 5, 13, 2, 3, 15)

  val result = (1 to numbers.size).flatMap(s => {
    numbers.combinations(s).map(c => c.sum)
  }).groupBy(identity).map { case (num, g) => (num, g.size) }.maxBy(_._2)._1

  println(result)
}
