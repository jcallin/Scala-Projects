package com.scalaprojects.exercises.leetcode

import com.scalaprojects.exercises.leetcode.datastructures.TreeNode

object SumOfNodesWithEvenValueGrandparents {
  def sumEvenGrandparent(root: TreeNode): Int = {
    def sumEvenGrandparentHelper(r: TreeNode, willSumChildren: Boolean): Int = {
      if (r == null) {
        0
      } else {
        val isEven = r.value % 2 == 0

        val lChildValue =
          if (r.left != null && willSumChildren) r.left.value else 0
        val rChildValue =
          if (r.right != null && willSumChildren) r.right.value else 0

        lChildValue + rChildValue + sumEvenGrandparentHelper(
          r.left,
          isEven
        ) + sumEvenGrandparentHelper(
          r.right,
          isEven
        )

      }
    }

    sumEvenGrandparentHelper(root, false)
  }

}
