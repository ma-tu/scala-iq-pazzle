package q7

import java.text.SimpleDateFormat
import java.util.Calendar

object Main extends App {
  util.Properties.setProp("scala.time", "")

  val dt = new SimpleDateFormat("yyyyMMdd")
  val startDate = dt.parse("19641010")
  val endDate = dt.parse("20200724")
  val days = ((endDate.getTime - startDate.getTime) / (24 * 60 * 60 * 1000)).toInt
  val cal = Calendar.getInstance()

  val dateList = (0 to days).map(n => {
    cal.setTime(startDate)
    cal.add(Calendar.DATE, n)
    dt.format(cal.getTime).toInt
  })

  val result = dateList.filter(d => d.toBinaryString.reverse == d.toBinaryString)
  result.foreach(println)
}
