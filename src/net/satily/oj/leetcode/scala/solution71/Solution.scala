package net.satily.oj.leetcode.scala.solution71

object Solution {
  def simplifyPath(path: String): String = {
      "/" +
        path
          .split("/")
          .foldLeft(Seq.empty[String]) {
            case (seq, ele) if ele == ".." && seq.nonEmpty =>
              seq.dropRight(1)
            case (seq, ele) if (ele == ".." && seq.isEmpty) || ele == "." || ele == "" =>
              seq
            case (seq, ele) =>
              seq :+ ele
          }
          .mkString("/")
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    println(Solution.simplifyPath("/home/"))
    println(Solution.simplifyPath("/a/./b/../../c/"))
    println(Solution.simplifyPath("/a/../../b/../c//.//"))
    println(Solution.simplifyPath("/a//b////c/d//././/.."))
    println(Solution.simplifyPath("/"))
  }
}
