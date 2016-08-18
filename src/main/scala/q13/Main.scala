package q13

object Main extends App {
  util.Properties.setProp("scala.time", "")

  val chars = List("R", "E", "A", "D", "W", "I", "T", "L", "K", "S")

  val result = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9).permutations.map(num => {
    chars.zip(num).map { case (c, n) => c.toString -> n }.toMap
  }).filter(pairs => {
    (pairs("R") != 0) && (pairs("W") != 0) && (pairs("T") != 0) && (pairs("S") != 0) &&
      ((pairs("W") + 1 == pairs("S")) || (pairs("W") + 1 == pairs("S")))
  }).filter(pairs =>
    add(add(toNum("READ", pairs), toNum("WRITE", pairs)), toNum("TALK", pairs)) == toNum("SKILL", pairs)
  )

  result.foreach(println)

  def toNum(exp: String, pairs: Map[String, Int]) = {
    BigInt(exp.zipWithIndex.map { case (c, index) => {
      Math.pow(10, exp.length - index - 1) * pairs(c.toString)
    }
    }.sum.toLong)
  }

  def add(left: BigInt, right: BigInt) = left + right
}
