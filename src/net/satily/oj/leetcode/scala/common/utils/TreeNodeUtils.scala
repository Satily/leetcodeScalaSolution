package net.satily.oj.leetcode.scala.common.utils

import net.satily.oj.leetcode.scala.common.structure.TreeNode

object TreeNodeUtils {
  def create(value: Int, left: TreeNode = null, right: TreeNode = null): TreeNode = TreeNode(value, left, right)

  def toTuple(treeNode: TreeNode): (Int, TreeNode, TreeNode) = (treeNode._value, treeNode.left, treeNode.right)
}
