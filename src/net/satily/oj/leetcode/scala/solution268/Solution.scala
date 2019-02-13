package net.satily.oj.leetcode.scala.solution268

object Solution {
  def missingNumber(nums: Array[Int]): Int = {
    nums.length * (nums.length + 1) / 2 - nums.sum
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    println(Solution.missingNumber(Array(3, 0, 1)))
    println(Solution.missingNumber(Array(9, 6, 4, 2, 3, 5, 7, 0, 1)))
  }
}