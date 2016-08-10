package q9

import scala.collection.mutable

object Main extends App {
  def printTime(f: => Unit): Unit = {
    val start = System.currentTimeMillis()
    f
    println((System.currentTimeMillis() - start) + " msec")
  }

  sealed abstract class HUMAN

  object HUMAN {

    case object MAN extends HUMAN

    case object WOMAN extends HUMAN

    def values = List(MAN, WOMAN)
  }

  def next(maxMan: Int, maxWoman: Int, waitingMan: Int, waitingWoman: Int): Int = {
    if ((maxMan - waitingMan == 0) && (maxWoman - waitingWoman == 0)) {
      1
    } else if ((waitingMan > 0) && (waitingWoman > 0) && (waitingMan == waitingWoman) || (maxMan - waitingMan == maxWoman - waitingWoman)) {
      0
    } else {
      HUMAN.values.foldLeft(0)((z, n) => {
        n match {
          case HUMAN.MAN =>
            if (maxMan > waitingMan) {
              z + next(maxMan, maxWoman, waitingMan + 1, waitingWoman)
            } else {
              z
            }
          case HUMAN.WOMAN =>
            if (maxWoman > waitingWoman) {
              z + next(maxMan, maxWoman, waitingMan, waitingWoman + 1)
            } else {
              z
            }
        }
      })
    }
  }

  printTime {
    println("網羅的に探索してみた")
    val result = next(20, 10, 0, 0)
    println(result)
  }

  def crossSum(x: Int, y: Int) = {
    val sumArray: mutable.HashMap[(Int, Int), Int] = mutable.HashMap((0, 0) -> 1)

    (0 to x).foreach(xx => {
      (0 to y).foreach(yy => {
        if ((xx != yy) && (x - xx != y - yy)) {
          if (xx > 0) {
            sumArray.put((xx, yy), sumArray.getOrElse((xx, yy), 0) + sumArray.getOrElse((xx - 1, yy), 0))
          }
          if (yy > 0) {
            sumArray.put((xx, yy), sumArray.getOrElse((xx, yy), 0) + sumArray.getOrElse((xx, yy - 1), 0))
          }
        }
      })
    })

    sumArray.toMap
  }

  printTime {
    println("最短経路探索法で交点で加算しながら計算")
    val result = crossSum(20, 10)
    println(result(19, 10) + result(20, 9))
  }

}
