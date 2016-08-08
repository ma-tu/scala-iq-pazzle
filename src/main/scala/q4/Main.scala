package q4

object Main extends App {
  def printTime(f: => Unit) = {
    val start = System.currentTimeMillis
    f
    println((System.currentTimeMillis - start) + "msec")
  }

  printTime {
    println("n = 20, m = 3")
    println(calc(20, 3))
  }

  printTime {
    println("n = 100, m = 5")
    println(calc(100, 5))
  }

  def calc(len: Int, human: Int) = {
    cut(0, List(len), human)
  }

  def cut(count: Int, branches: List[Int], human: Int): Int = {
    //長さが　1 以上のものを残して逆順に並び替える
    val targetBranches = branches.filterNot(_ <= 1).sorted.reverse

    if (targetBranches.isEmpty) {
      count
    } else {
      val remainBranches = targetBranches.drop(human)
      val cuttenBranches = targetBranches.take(human).flatMap(branch => {
        List(branch / 2, (branch / 2) + (branch % 2))
      })

      cut(count + 1, remainBranches ++ cuttenBranches, human)
    }
  }
}
