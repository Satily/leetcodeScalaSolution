package net.satily.oj.leetcode.scala.solution478

class Solution(_radius: Double, _x_center: Double, _y_center: Double) {
  private val random: util.Random = new util.Random()
  def randPoint(): Array[Double] = {
    val x = random.nextDouble() * 2 - 1.0
    val maxY = math.sqrt(1 - math.abs(x))
    val y = (random.nextDouble() * 2 - 1.0) * maxY
    Array(_x_center + x * _radius, _y_center + y * _radius)
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    new Solution(1,0,0).randPoint().foreach(println)
    new Solution(10,5,-7.5).randPoint().foreach(println)
  }
}