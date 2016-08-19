package q17

object Main extends App {
  util.Properties.setProp("scala.time", "")

  def addPerson(last: Boolean, remain: Int): Int = {
    if (remain == 0) {
      1
    } else {
      if (last) {
        var count = addPerson(true, remain - 1)
        count += addPerson(false, remain - 1)
        count
      } else {
        addPerson(true, remain - 1)
      }
    }
  }

  var count = addPerson(true, 30 - 1)
  count += addPerson(false, 30 - 1)
  println(count)
}
