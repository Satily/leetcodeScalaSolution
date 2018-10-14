package net.satily.oj.leetcode.scala.solution657

object Solution {
  def judgeCircle(moves: String): Boolean = {
    val direction = Map(
      'U' -> (-1, 0),
      'D' -> (1, 0),
      'L' -> (0, -1),
      'R' -> (0, 1)
    )
    moves.map(direction.get).map(_.get).fold((0, 0))((a, b) => (a._1 + b._1, a._2 + b._2)) match {
      case (0, 0) => true
      case _ => false
    }
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    println(Solution.judgeCircle(""))
    println(Solution.judgeCircle("LL"))
  }
}
