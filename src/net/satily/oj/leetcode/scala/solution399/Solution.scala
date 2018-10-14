package net.satily.oj.leetcode.scala.solution399

object Solution {
  // Path Finder
  def calcEquation(equations: Array[Array[String]], values: Array[Double], queries: Array[Array[String]]): Array[Double] = {
    val NOT_FOUND: Double = -1.0
    val graph: Map[String, Map[String, Double]] = equations
      .map(t => t(0) -> t(1))
      .filterNot(t => t._1 == t._2)
      .zip(values)
      .flatMap(p => Seq(p, (p._1.swap, 1 / p._2)))
      .toMap
      .groupBy(_._1._1)
      .mapValues {
        _.map {
          case ((_, right), width) => (right, width)
        }.toMap
      }
    val nodesSet: Set[String] = equations.flatten.toSet

    def searchPath(current: String, destination: String, path: Set[String]): Double = {
      var result: Double = NOT_FOUND
      if (current == destination) {
        result = 1
      } else {
        for {
          edges <- graph.get(current)
          edge <- edges
          if result == NOT_FOUND && !path.contains(edge._1)
        } {
          val l: Double = searchPath(edge._1, destination, path + edge._1)
          if (l != NOT_FOUND) {
            result = edge._2 * l
          }
        }
      }
      result
    }

    queries.map(t => (t(0), t(1))).map {
      case (s, d) if nodesSet.contains(s) && nodesSet.contains(d) =>
        searchPath(s, d, Set(s))
      case _ => NOT_FOUND
    }
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    Solution.calcEquation(
      Array(Array("a", "b"), Array("b", "c")),
      Array(2.0, 3.0),
      Array(Array("a", "c"), Array("b", "a"), Array("a", "e"), Array("a", "a"), Array("x", "x"))
    ).foreach(println)
    Solution.calcEquation(
      Array(Array("x1", "x2"), Array("x2", "x3"), Array("x1", "x4"), Array("x2", "x5")),
      Array(3.0, 0.5, 3.4, 5.6),
      Array(Array("x2", "x4"), Array("x1", "x5"), Array("x1", "x3"), Array("x5", "x5"), Array("x5", "x1"),
        Array("x3", "x4"), Array("x4", "x3"), Array("x6", "x6"), Array("x0", "x0"))
    ).foreach(println)
  }
}
