package net.satily.oj.leetcode.scala.solution203

import net.satily.oj.leetcode.scala.common.{ListNode, ListNodeUtils}

object Solution {
    def removeElements(head: ListNode, `val`: Int): ListNode = {
        var lHead: ListNode = new ListNode(0)
        lHead.next = head
        var p = lHead
        while (p.next != null) {
            if (p.next.x == `val`) {
                p.next = p.next.next
                if (p == lHead) {
                    lHead = p
                }
            } else {
                p = p.next
            }
        }
        lHead.next
    }
}

object Main {
    def main(args: Array[String]): Unit = {
        println(ListNodeUtils.toList(Solution.removeElements(ListNodeUtils.fromList(List(1, 2, 6, 3, 4, 5, 6)), 6)))
        println(ListNodeUtils.toList(Solution.removeElements(null, 6)))
        println(ListNodeUtils.toList(Solution.removeElements(ListNodeUtils.fromList(List(1)), 1)))
    }
}
