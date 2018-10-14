package net.satily.oj.leetcode.scala.solution2

import net.satily.oj.leetcode.scala.common.{ListNode, ListNodeUtils}

object Solution {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    var result: ListNode = new ListNode()
    (l1, l2) match {
      case (null, null) => result = new ListNode(0)
      case (null, _) => result = l2
      case (_, null) => result = l1
      case _ =>
        def getNum(p: Option[ListNode]): Int = p.map(_.x).getOrElse(0)

        def getNext(p: Option[ListNode]): Option[ListNode] = p.map(_.next).flatMap(Option(_))

        var p = result
        var p1 = Option(l1)
        var p2 = Option(l2)
        var inc = 0
        while (p1.isDefined || p2.isDefined || inc != 0) {
          val num = getNum(p1) + getNum(p2) + inc
          inc = num / 10
          p.next = new ListNode(num % 10)
          p = p.next
          p1 = getNext(p1)
          p2 = getNext(p2)
        }
    }
    result.next
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    val l1 = ListNodeUtils.fromList(List(0))
    val l2 = ListNodeUtils.fromList(List(0))
    ListNodeUtils.toList(Solution.addTwoNumbers(l1, l2)).foreach(println(_))
  }
}