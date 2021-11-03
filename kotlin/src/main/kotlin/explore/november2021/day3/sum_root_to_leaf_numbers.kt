package explore.november2021.day3


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun sumNumbers(root: TreeNode?): Int {
        return root?.let { dfs(it, 0) } ?: 0
    }

    fun dfs(node: TreeNode, num: Int): Int {
        val crtNum = num * 10 + node.`val`
        if (node.left == null && node.right == null) {
            return crtNum
        }

        var res = 0
        res += node.left?.let { dfs(it, crtNum) } ?: 0
        res += node.right?.let { dfs(it, crtNum) } ?: 0
        return res
    }
}
