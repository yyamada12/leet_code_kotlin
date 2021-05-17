package explore.may2021.day16

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun minCameraCover(root: TreeNode?): Int {
        val monitored = mutableSetOf<TreeNode>()
        val withCamera = mutableSetOf<TreeNode>()
        if (root == null) {
            return 0
        }
        fun dfs(node: TreeNode?, parent: TreeNode) {
            if (node == null) {
                return
            }
            if (node.left == null && node.right == null) {
                if (monitored.contains(node)) {
                    return
                }
                withCamera.add(parent)
                monitored.add(node)
                return
            }

            dfs(node.left, node)
            dfs(node.right, node)
            if (withCamera.contains(node)) {
                monitored.add(parent)
                monitored.add(node)
                return
            }
            if (!monitored.contains(node)) {
                withCamera.add(parent)
                monitored.add(node)
            }
        }

        val p = TreeNode(0)
        p.left = root
        dfs(root, p)
        return withCamera.size
    }
}