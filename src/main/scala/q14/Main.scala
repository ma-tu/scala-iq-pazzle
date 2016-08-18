package q14

object Main extends App {
  util.Properties.setProp("scala.time", "")

  val countries = Set("Brazil", "Croatia", "Mexico", "Cameroon", "Spain",
    "Netherlands", "Chile", "Australia", "Colombia", "Greece",
    "Cote d'lvoire", "Japan", "Uruguay", "Costa Rica", "England",
    "Italy", "Switzerland", "Ecuador", "France", "Honduras",
    "Argentina", "Bosnia and Herzegovina", "Iran", "Nigeria", "Germany",
    "Portugal", "Ghana", "USA", "Belgium", "Algeria",
    "Russia", "Korea Republic")

  def nextCountry(country: String, remain: Set[String], sequence: List[String]): List[String] = {
    val targets = remain
      .filter(_.head == country.last)

    if (targets.isEmpty) {
      sequence
    } else {
      targets
        .map(c => {
          nextCountry(c, remain - c, sequence :+ c)
        })
        .maxBy(_.length)
    }

  }

  val upperCountries = countries
    .map(_.toUpperCase)

  val result = upperCountries
    .map(c => {
      nextCountry(c, upperCountries - c, List(c))
    })
    .maxBy(_.length)

  println(result.length)
}
