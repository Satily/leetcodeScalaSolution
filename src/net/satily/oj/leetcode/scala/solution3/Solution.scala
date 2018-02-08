package net.satily.oj.leetcode.scala.solution3

object Solution {
    def lengthOfLongestSubstring(s: String): Int = {
        val charSet = scala.collection.mutable.Set.empty[Char]
        var longest = 0
        var q = 0
        for (p <- 0.until(s.length)) {
            while (charSet.contains(s(p))) {
                charSet.remove(s(q))
                q += 1
            }
            charSet.add(s(p))
            longest = longest.max(p - q + 1)
        }
        longest
    }
}

object Main {
    def main(args: Array[String]): Unit = {
        println(Solution.lengthOfLongestSubstring("abcabcbb"))
        println(Solution.lengthOfLongestSubstring("bbbbb"))
        println(Solution.lengthOfLongestSubstring("pwwkew"))
    }
}
