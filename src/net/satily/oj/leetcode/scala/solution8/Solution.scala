package net.satily.oj.leetcode.scala.solution8

object Solution {

  def myAtoi(str: String): Int = {
    val maxInt: Long = 2147483647L
    val minInt: Long = -2147483648L
    val numbers: Set[Char] = ('0' to '9').toSet

    def parse(rest: Seq[Char]): Long = {
      rest
        .takeWhile(numbers.contains)
        .dropWhile(_ == '0')
        .take(11)
        .foldLeft(0L)((acc, obj) => acc * 10 + (obj - '0'))
    }

    val res = str.trim.toList match {
      case '+' :: rest =>
        parse(rest)
      case '-' :: rest =>
        -parse(rest)
      case rest =>
        parse(rest)
    }

    Seq(Seq(minInt, res).max, maxInt).min.toInt
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    println(Solution.myAtoi("42"))
    println(Solution.myAtoi("   -42"))
    println(Solution.myAtoi("4193 with words"))
    println(Solution.myAtoi("words and 987"))
    println(Solution.myAtoi("-91283472332"))
    println(Solution.myAtoi("  0000000000012345678"))
    println(Solution.myAtoi("20000000000000000000"))
  }
}