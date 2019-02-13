package net.satily.oj.leetcode.scala.solution62

object Solution {
  def uniquePaths(m: Int, n: Int): Int = {
    val dp = collection.mutable.Seq.fill(n)(0)

    m

    for {
      i <- 1 to m
    }
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    println(Solution.uniquePaths(3, 2))
    println(Solution.uniquePaths(7, 3))
  }
}