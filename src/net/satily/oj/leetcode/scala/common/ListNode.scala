package net.satily.oj.leetcode.scala.common

import scala.collection.mutable

class ListNode(var _x: Int = 0) {
   var next: ListNode = null
   var x: Int = _x
}

object ListNodeUtils {
    def fromList(list: List[Int]): ListNode = list match {
        case Nil => null
        case _ =>
            val node = new ListNode(list.head)
            node.next = fromList(list.drop(1))
            node
    }

    def toList(listNode: ListNode): List[Int] = {
        val result: mutable.MutableList[Int] = mutable.MutableList.empty
        var p = listNode
        while (p != null) {
            result += p.x
            p = p.next
        }
        result.toList
    }

    def main(args: Array[String]): Unit = {
        toList(fromList(List(1, 2, 3, 2, 1))).foreach(println(_))
    }
}