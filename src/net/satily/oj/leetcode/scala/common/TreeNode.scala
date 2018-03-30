package net.satily.oj.leetcode.scala.common

class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
}

object TreeNodeUtils {
    def create(value: Int, left: TreeNode = null, right: TreeNode = null): TreeNode = {
        val treeNode: TreeNode = new TreeNode(value)
        treeNode.left = left
        treeNode.right = right
        treeNode
    }
    def toTuple(treeNode: TreeNode): (Int, TreeNode, TreeNode) = (treeNode._value, treeNode.left, treeNode.right)
}
