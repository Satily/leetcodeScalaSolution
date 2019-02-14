package net.satily.oj.leetcode.scala.common.utils

import net.satily.oj.leetcode.scala.common.structure.TreeNode

object TreeNode {
  def apply(value: Int, left: TreeNode = null, right: TreeNode = null): TreeNode = {
    val treeNode: TreeNode = new TreeNode(value)
    treeNode.left = left
    treeNode.right = right
    treeNode
  }
}
