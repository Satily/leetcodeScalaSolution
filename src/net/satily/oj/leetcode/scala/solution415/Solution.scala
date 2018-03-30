package net.satily.oj.leetcode.scala.solution415

object Solution {
    def addStrings(num1: String, num2: String): String = {
        val (rs, ri) = num1.reverse.zipAll(num2.reverse, '0', '0').foldLeft(("", 0)) {
            case ((s, i), (c1, c2)) =>
                (s + ((c1 + c2 + i - '0' * 2) % 10), (c1 + c2 + i - '0' * 2) / 10)
        }
        (rs + (if (ri == 1) "1" else "")).reverse
    }
}

object Main {
    def main(args: Array[String]): Unit = {
        println(Solution.addStrings("1234", "4344"))
        println(Solution.addStrings("34", "4388"))
        println(Solution.addStrings("1234", "43"))
        println(Solution.addStrings("9", "99"))
    }
}
