package explore.may2021.day14

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun flatten(root: TreeNode?): Unit {
        var crt = TreeNode(0)
        fun dfs(node: TreeNode?) {
            if (node == null) {
                return
            }
            crt.right = node
            crt.left = null
            crt = node
            val r = node.right
            dfs(node.left)
            dfs(r)
        }
        dfs(root)
    }
}