package q5

object Main extends App {
  util.Properties.setProp("scala.time", "")

  def change(combination: List[Int], money: Int, coins: List[Int], remain: Int): List[List[Int]] = {
    if (money == 0) {
      List(combination)
    } else {
      if (coins.isEmpty) {
        List.empty
      } else {
        val coin = coins.head
        val count = money / coin
        if (count > remain) {
          List.empty
        } else {
          (0 to count).flatMap(coinCount => {
            change(combination ++: List.empty.padTo(coinCount, coin), money - coin * coinCount, coins.tail, remain - coinCount)
          }).toList
        }
      }
    }
  }

  val result = change(List.empty[Int], 1000, List(500, 100, 50, 10), 15)
  println(result.length)
}
