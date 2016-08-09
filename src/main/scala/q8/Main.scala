package q8

//23:58
object Main extends App {

  sealed abstract class DIRECTION

  object DIRECTION {

    case object START extends DIRECTION

    case object UP extends DIRECTION

    case object DOWN extends DIRECTION

    case object RIGHT extends DIRECTION

    case object LEFT extends DIRECTION

    val directions = List(UP, DOWN, RIGHT, LEFT)
  }

  def move(direction: DIRECTION, remain: Int, position: (Int, Int), tracks: List[(Int, Int)]): List[List[(Int, Int)]] = {
    if (remain == 0) {
      List(tracks)
    } else {
      DIRECTION.directions
        .flatMap(newDirection => {

          val newPosition =
            newDirection match {
              case DIRECTION.UP => (position._1, position._2 - 1)
              case DIRECTION.DOWN => (position._1, position._2 + 1)
              case DIRECTION.RIGHT => (position._1 + 1, position._2)
              case DIRECTION.LEFT => (position._1 - 1, position._2)
            }

          if (tracks.contains(newPosition)) {
            List.empty
          } else {
            move(newDirection, remain - 1, newPosition, tracks :+ newPosition)
          }
        })
    }
  }

  var result = move(DIRECTION.START, 12, (0, 0), List((0, 0)))
  println(result.length)
}
