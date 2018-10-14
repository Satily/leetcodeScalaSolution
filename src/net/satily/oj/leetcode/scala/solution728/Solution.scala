package net.satily.oj.leetcode.scala.solution728

object Solution {
  def selfDividingNumbers(left: Int, right: Int): List[Int] = {
    (left to right)
      .map {
        num =>
          num ->
            Seq
              .iterate(num, 5)(_ / 10)
              .filter(_ != 0)
              .map(_ % 10)
              .map(i => i != 0 && num % i == 0)
              .reduceOption(_ && _)
      }
      .filter(_._2.contains(true))
      .map(_._1)
      .toList
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    println(Solution.selfDividingNumbers(1, 22))
  }
}