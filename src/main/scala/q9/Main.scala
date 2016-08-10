package q9

object Main extends App {
  util.Properties.setProp("scala.time", "")

  sealed abstract class HUMAN

  object HUMAN {

    case object MAN extends HUMAN

    case object WOMAN extends HUMAN

    def values = List(MAN, WOMAN)
  }

  def next(maxMan: Int, maxWoman: Int, waitingMan: Int, waitingWoman: Int, sequence: List[HUMAN]): Int = {
    if ((maxMan - waitingMan == 0) && (maxWoman - waitingWoman == 0)) {
      1
    } else if ((waitingMan > 0) && (waitingWoman > 0) && (waitingMan == waitingWoman) || (maxMan - waitingMan == maxWoman - waitingWoman)) {
      0
    } else {
      HUMAN.values.foldLeft(0)((z, n) => {
        n match {
          case HUMAN.MAN =>
            if (maxMan > waitingMan) {
              z + next(maxMan, maxWoman, waitingMan + 1, waitingWoman, sequence :+ HUMAN.MAN)
            } else {
              z
            }
          case HUMAN.WOMAN =>
            if (maxWoman > waitingWoman) {
              z + next(maxMan, maxWoman, waitingMan, waitingWoman + 1, sequence :+ HUMAN.WOMAN)
            } else {
              z
            }
        }
      })
    }
  }

  val result = next(20, 10, 0, 0, List.empty)
  println(result)
}
