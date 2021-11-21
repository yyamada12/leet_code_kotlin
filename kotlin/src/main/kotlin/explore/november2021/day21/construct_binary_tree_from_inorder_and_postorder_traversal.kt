package explore.november2021.day21


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        return dfs(inorder.toList(), postorder.toList())
    }

    fun dfs(inorder: List<Int>, postorder: List<Int>): TreeNode? {
        if (inorder.isEmpty()) {
            return null
        }

        val root = postorder.last()
        val res = TreeNode(root)

        val leftIn = mutableListOf<Int>()
        val leftPost = mutableListOf<Int>()
        val rightIn = mutableListOf<Int>()
        val rightPost = mutableListOf<Int>()

        var isLeft = true
        for (i in inorder.indices) {
            if (inorder[i] == root) {
                isLeft = false
                rightPost.add(postorder[i])
                continue
            }
            if (isLeft) {
                leftIn.add(inorder[i])
                leftPost.add(postorder[i])
            } else {
                rightIn.add(inorder[i])
                if (postorder[i] != root) {
                    rightPost.add(postorder[i])
                }
            }
        }
        res.left = dfs(leftIn, leftPost)
        res.right = dfs(rightIn, rightPost)
        return res
    }
}
