package net.satily.oj.leetcode.scala.solution890

object Solution {
  def findAndReplacePattern(words: Array[String], pattern: String): List[String] = {
    words
      .toList
      .flatMap {
        word =>
          val t =
            word
              .zip(pattern)
              .distinct
          if (t.map(_._1).distinct.size == t.size && t.map(_._2).distinct.size == t.size) {
            Some(word)
          } else {
            None
          }
      }
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    println(Solution.findAndReplacePattern(Array("abc","deq","mee","aqq","dkd","ccc"), "abb"))
  }
}