package com.scalaprojects.exercises.leetcode.DFS

import com.scalaprojects.exercises.leetcode.datastructures.TreeNode

object SameTree {
  def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
    if (p == null && q == null) true
    else if (p == null ^ q == null) false
    else if (p.value == q.value) { isSameTree(p.left, q.left) && isSameTree(p.right, q.right) }
    else false
  }
}
