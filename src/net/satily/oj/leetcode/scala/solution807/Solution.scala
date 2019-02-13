package net.satily.oj.leetcode.scala.solution807

object Solution {
  def maxIncreaseKeepingSkyline(grid: Array[Array[Int]]): Int = {
    val rowMax: Array[Int] =
      grid
        .map(_.max)
    val colMax: Array[Int] =
      grid
        .flatMap(_.zipWithIndex)
        .groupBy(_._2)
        .mapValues(_.map(_._1).max)
        .toArray
        .sortBy(_._1)
        .map(_._2)
    val gridSum: Int =
      grid
        .flatten
        .sum
    val gridNewSum: Int =
      (
        for {
          i <- rowMax
          j <- colMax
        } yield {
          math.min(i, j)
        }
      ).sum
    gridNewSum - gridSum
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    println(
      Solution
        .maxIncreaseKeepingSkyline(
          Array(
            Array(3, 0, 8, 4),
            Array(2, 4, 5, 7),
            Array(9, 2, 6, 3),
            Array(0, 3, 1, 0)
          )
        )
    )
  }
}