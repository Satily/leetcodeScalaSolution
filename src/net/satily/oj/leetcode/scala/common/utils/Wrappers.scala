package net.satily.oj.leetcode.scala.common.utils

import net.satily.oj.leetcode.scala.common.structure.{ListNode, TreeNode}

object Wrappers {
  implicit class ListNodeWrapper(val listNode: ListNode) {
    def toList: List[Int] =
      listNode match {
        case null => Nil
        case node => node.x +: node.next.toList
      }
  }
  implicit class TreeNodeWrapper(val treeNode: TreeNode) {

  }
  implicit class ListToListNodeWrapper(val list: List[Int]) {
    def toListNode: ListNode = ListNode(list)
  }

  def main(args: Array[String]): Unit = {
    List(1, 2, 3, 2, 1).toListNode.toList.foreach(println)
  }
}
