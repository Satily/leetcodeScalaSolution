package net.satily.oj.leetcode.scala.solution63

object Solution {
  def uniquePathsWithObstacles(obstacleGrid: Array[Array[Int]]): Int = {
    val dp = collection.mutable.Seq.fill(obstacleGrid.length)(collection.mutable.Seq.fill(obstacleGrid.headOption.map(_.length).getOrElse(0))(0))
    for {
      i <- obstacleGrid.indices
      j <- obstacleGrid(i).indices
    } {
      if (obstacleGrid(i)(j) == 1) {
        dp(i)(j) = 0
      } else if (i == 0 && j == 0) {
        dp(i)(j) = 1
      } else {
        if (i != 0 && obstacleGrid(i - 1)(j) == 0) {
          dp(i)(j) += dp(i - 1)(j)
        }
        if (j != 0 && obstacleGrid(i)(j - 1) == 0) {
          dp(i)(j) += dp(i)(j - 1)
        }
      }
    }
    dp.lastOption.flatMap(_.lastOption).getOrElse(0)
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    println(
      Solution
        .uniquePathsWithObstacles(
          Array(
            Array(0, 0, 0),
            Array(0, 1, 0),
            Array(0, 0, 0)
          )
        )
    )
    println(
      Solution
        .uniquePathsWithObstacles(
          Array(
            Array(1)
          )
        )
    )
  }
}
