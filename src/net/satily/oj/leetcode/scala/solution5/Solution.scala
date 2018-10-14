package net.satily.oj.leetcode.scala.solution5

object Solution {
  def longestPalindrome(s: String): String = {
    0.until(s.length)
      .flatMap(index => 0.until(2).map((index, _)))
      .take(s.length * 2 - 1)
      .map {
        case (index, d) =>
          var p = 0
          while (s.isDefinedAt(index + p + d) && s.isDefinedAt(index - p) && s(index + p + d) == s(index - p)) {
            p += 1
          }
          (index - p + 1, p * 2 + d - 1)
      }.maxBy(_._2) match {
      case (start, length) => s.substring(start, start + length)
    }
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    println(Solution.longestPalindrome("babad"))
    println(Solution.longestPalindrome("cbbd"))
  }
}

