package net.satily.oj.leetcode.scala.solution324

object Solution {
  def wiggleSort(nums: Array[Int]): Unit = {
    val data = Int.MaxValue +: nums
    for (index <- 1 until data.length) {
      data(index) 
    }
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    println(Solution.wiggleSort(Array(1, 5, 1, 1, 6, 4)))
    println(Solution.wiggleSort(Array(1, 3, 2, 2, 3, 1)))
  }
}