package q3

import scala.collection.mutable

object Main extends App {
  util.Properties.setProp("scala.time", "")

  val showList = mutable.HashSet.empty[Int]

  def reverseCard(num: Int) = {
    if (showList.contains(num)) {
      showList -= num
    } else {
      showList += num
    }
  }

  (2 to 100).foreach(n => {
    (n to 100 by n).foreach(m => reverseCard(m))
  })

  (1 to 100)
    .filterNot(r => showList.contains(r))
    .foreach(println)
}
