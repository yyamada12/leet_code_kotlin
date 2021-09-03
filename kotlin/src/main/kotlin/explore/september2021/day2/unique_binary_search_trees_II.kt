package explore.september2021.day2

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun generateTrees(n: Int): List<TreeNode?> {
        return generateTrees(1, n + 1)
    }

    private fun generateTrees(a: Int, b: Int): List<TreeNode?> {
        if (a == b) {
            return listOf(null)
        }
        if (a == b - 1) {
            return listOf(TreeNode(a))
        }
        val res = mutableListOf<TreeNode?>()
        for (n in a until b) {
            for (l in generateTrees(a, n)) {
                for (r in generateTrees(n + 1, b)) {
                    res.add(TreeNode(n).apply {
                        left = l
                        right = r
                    })
                }
            }
        }
        return res
    }
}
