package explore.may2021.day20

import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return listOf()
        }
        val m = mutableMapOf<Int, MutableList<Int>>()
        val q = ArrayDeque<Pair<TreeNode, Int>>()
        q.add(root to 0)
        while (!q.isEmpty()) {
            val (node, level) = q.poll();
            node.left?.let {
                q.add(it to level + 1)
            }
            node.right?.let {
                q.add(it to level + 1)
            }
            m.append(level, node.`val`)
        }
        return m.values.toList()
    }
}

fun MutableMap<Int, MutableList<Int>>.append(key: Int, value: Int) {
    val list = this[key] ?: mutableListOf()
    list.add(value)
    this[key] = list
}