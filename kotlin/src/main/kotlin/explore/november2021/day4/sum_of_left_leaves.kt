package explore.november2021.day4

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun sumOfLeftLeaves(root: TreeNode?): Int {
        return dfs(false, root)
    }

    fun dfs(isLeft: Boolean, node: TreeNode?): Int {
        if (node == null) {
            return 0
        }
        if (node.left == null && node.right == null) {
            return if (isLeft) node.`val` else 0
        }
        return dfs(true, node.left) + dfs(false, node.right)
    }
}
