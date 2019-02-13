package net.satily.oj.leetcode.scala.solution258

object Solution {
  def addDigits(num: Int): Int = {
    (num, num % 9) match {
      case (0, _) => 0
      case (_, 0) => 9
      case (_, x) => x
    }
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    println(Solution.addDigits(38))
  }
}