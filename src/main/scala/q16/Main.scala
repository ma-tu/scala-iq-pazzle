package q16

object Main extends App {
  util.Properties.setProp("scala.time", "")

  val MAX = 500
  val combinations = (1 to MAX / 4).flatMap(len => {
    (1 until len).combinations(2)
      .map(rect => {
        (len, rect(0), rect(1))
      })
  }).filter(pair => {
    pair._1 * pair._1 == pair._2 * ((pair._1 * 2) - pair._2) + pair._3 * ((pair._1 * 2) - pair._3)
  })

  println(combinations
    .map(c => (c._2.toDouble / c._1, c._3.toDouble / c._1))
    .distinct
    .length)
}
