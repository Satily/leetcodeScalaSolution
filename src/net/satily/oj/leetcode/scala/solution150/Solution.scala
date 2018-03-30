package net.satily.oj.leetcode.scala.solution150

object Solution {
    def evalRPN(tokens: Array[String]): Int = {
        tokens.foldLeft(Seq.empty[Long]) { (r, c) =>
            def cal(op: (Long, Long) => Long) = r.dropRight(2) :+ op(r.dropRight(1).last, r.last)
            c match {
                case "+" => cal(_ + _)
                case "-" => cal(_ - _)
                case "*" => cal(_ * _)
                case "/" => cal(_ / _)
                case _ => r :+ c.toLong
            }
        }.head.toInt
    }
}

object Main {
    def main(args: Array[String]): Unit = {
        println(Solution.evalRPN(Array("2", "1", "+", "3", "*")))
        println(Solution.evalRPN(Array("4", "13", "5", "/", "+")))
    }
}