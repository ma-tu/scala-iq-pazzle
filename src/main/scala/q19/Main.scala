package q19

object Main {
  val primes = sieve(Stream.from(2))

  def sieve(xs: Stream[Int]): Stream[Int] =
    Stream.cons(xs.head, sieve(xs.tail.filter(_ % xs.head != 0)))

  def main(args: Array[String]): Unit = {
    primes.take(10).foreach(println)
  }
}
