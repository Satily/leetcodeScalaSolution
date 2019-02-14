package net.satily.oj.leetcode.scala.common.utils

import net.satily.oj.leetcode.scala.common.structure.ListNode

object ListNode {
  def apply(list: List[Int]): ListNode =
    list match {
      case Nil => null
      case _ =>
        val node = new ListNode(list.head)
        node.next = ListNode(list.drop(1))
        node
    }
}
