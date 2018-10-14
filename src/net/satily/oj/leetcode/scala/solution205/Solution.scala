package net.satily.oj.leetcode.scala.solution205

object Solution {
  def isIsomorphic(s: String, t: String): Boolean = {
    if (s.length != t.length) {
      false
    } else {
      def validate(s: String, t: String): Boolean = {
        s.zip(t).groupBy(_._1).mapValues(_.map(_._2).toSet).forall(_._2.size <= 1)
      }

      validate(s, t) && validate(t, s)
    }
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    println(Solution.isIsomorphic("egg", "add"))
    println(Solution.isIsomorphic("foo", "bar"))
    println(Solution.isIsomorphic("paper", "title"))
  }
}
