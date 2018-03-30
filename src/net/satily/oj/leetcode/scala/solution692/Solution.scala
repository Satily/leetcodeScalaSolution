package net.satily.oj.leetcode.scala.solution692

object Solution {
    def topKFrequent(words: Array[String], k: Int): List[String] = {
        words.groupBy(_.self).mapValues(_.length).toList.sortWith {
            case ((s1, c1), (s2, c2)) => c1 > c2 || c1 == c2 && s1 < s2
        }.take(k).map(_._1)
    }
}

object Main {
    def main(args: Array[String]): Unit = {
        println(
            Solution.topKFrequent(
                Array(
                    "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is", "day"
                ), 4
            )
        )
    }
}
