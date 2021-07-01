package explore.june2021.day30

class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


class Solution {

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        val parents = mutableMapOf<Int, TreeNode>()
        val depths = mutableMapOf<Int, Int>()
        fun dfs(par: TreeNode, depth: Int) {
            depths[par.`val`] = depth
            par.left?.let {
                parents[it.`val`] = par
                dfs(it, depth + 1)
            }
            par.right?.let {
                parents[it.`val`] = par
                dfs(it, depth + 1)
            }
        }

        var p = p!!
        var q = q!!
        dfs(root!!, 0)

        val dp = depths[p.`val`]!!
        val dq = depths[q.`val`]!!
        if (dp > dq) {
            for (i in 0 until dp - dq) {
                p = parents[p.`val`]!!
            }
        } else {
            for (i in 0 until dq - dp) {
                q = parents[q.`val`]!!
            }
        }
        while (p != q) {
            p = parents[p.`val`]!!
            q = parents[q.`val`]!!
        }
        return p
    }
}