package net.satily.oj.leetcode.scala.solution112

import net.satily.oj.leetcode.scala.common.{TreeNode, TreeNodeUtils}

object Solution {
    def hasPathSum(root: TreeNode, sum: Int): Boolean = {
        Option(root).exists { root =>
            val current = sum - root._value

            def search(node: TreeNode) = Option(node).exists(hasPathSum(_, current))

            if (root.left == null && root.right == null) {
                current == 0
            } else {
                search(root.left) || search(root.right)
            }
        }
    }
}

object Main {
    def main(args: Array[String]): Unit = {
        println(
            Solution.hasPathSum(
                TreeNodeUtils.create(
                    5,
                    TreeNodeUtils.create(
                        4,
                        TreeNodeUtils.create(
                            11,
                            TreeNodeUtils.create(7),
                            TreeNodeUtils.create(2)
                        )
                    ),
                    TreeNodeUtils.create(
                        8,
                        TreeNodeUtils.create(13),
                        TreeNodeUtils.create(
                            4,
                            right = TreeNodeUtils.create(1)
                        )
                    )
                ), 22
           )
        )
        println(Solution.hasPathSum(null, 1))
    }
}