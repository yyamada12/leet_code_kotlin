package explore.may2021.day6

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun sortedListToBST(head: ListNode?): TreeNode? {
        var l = 0
        var node = head
        while (node != null) {
            node = node.next
            l++
        }
        return createTree(head, l)
    }

    fun createTree(head: ListNode?, l: Int): TreeNode? {
        if (l == 0) {
            return null
        }

        var node = head!!
        for (i in 0 until l / 2) {
            node = node.next!!
        }
        val res = TreeNode(node.`val`)
        res.left = createTree(head, l / 2)
        res.right = createTree(node.next, l - 1 - (l / 2))
        return res
    }
}