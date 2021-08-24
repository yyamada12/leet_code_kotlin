package explore.august2021.day23

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun findTarget(root: TreeNode?, k: Int): Boolean {
        return dfs(root, root, k)
    }

    fun dfs(root: TreeNode?, node: TreeNode?, k: Int): Boolean {
        if (node == null) {
            return false
        }
        if (find(root, node, k - node.`val`)) {
            return true
        }
        return dfs(root, node.left, k) || dfs(root, node.right, k)
    }

    fun find(root: TreeNode?, except: TreeNode?, k: Int): Boolean {
        if (root == null) {
            return false
        }
        if (root.`val` == k && root != except) {
            return true
        }
        return if (root.`val` < k) {
            find(root.right, except, k)
        } else {
            find(root.left, except, k)
        }
    }
}