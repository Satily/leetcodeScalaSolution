package net.satily.oj.leetcode.scala.solution78

object Solution {
  def subsets(nums: Array[Int]): List[List[Int]] =
    (0 to nums.length).flatMap(nums.combinations(_).map(_.toList)).toList
}

object Main {
  def main(args: Array[String]): Unit = {
    println(Solution.subsets(Array(1, 2, 3)))
    println(Solution.subsets(Array(1, 2, 3, 3)))
  }
}
