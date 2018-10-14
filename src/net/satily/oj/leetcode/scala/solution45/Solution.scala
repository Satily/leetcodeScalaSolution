package net.satily.oj.leetcode.scala.solution45


object Solution {
  def jump(nums: Array[Int]): Int = {
    val dp: scala.collection.mutable.Seq[Int] = scala.collection.mutable.Seq.fill(nums.length)(nums.length * 2)
    dp(0) = 0
    for {
      index <- nums.indices
      step <- 1 to nums(index)
      if index + step < nums.length
    } {
      dp(index + step) = math.min(dp(index) + 1, dp(index + step))
    }
    dp.last
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    println(Solution.jump(Array(2, 3, 1, 1, 4)))
  }
}