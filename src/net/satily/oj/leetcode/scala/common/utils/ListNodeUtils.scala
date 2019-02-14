package net.satily.oj.leetcode.scala.common.utils

import net.satily.oj.leetcode.scala.common.structure.ListNode

import scala.collection.mutable

object ListNodeUtils {
  def fromList(list: List[Int]): ListNode = ListNode(list)

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
