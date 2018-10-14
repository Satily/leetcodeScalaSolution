package net.satily.oj.leetcode.scala.solution349

object Solution {
  def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val num2Set = nums2.toSet
    nums1.filter(num2Set.contains).distinct
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    Solution.intersection(Array(1, 2, 2, 1), Array(2, 2)).foreach(println)
  }
}
