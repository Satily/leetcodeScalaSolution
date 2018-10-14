package net.satily.oj.leetcode.scala.solution575

object Solution {
  def distributeCandies(candies: Array[Int]): Int = {
    candies.toSet.size.min(candies.length / 2)
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    println(Solution.distributeCandies(Array(1, 1, 2, 2, 3, 3)))
    println(Solution.distributeCandies(Array(1, 1, 2, 3)))
  }
}
