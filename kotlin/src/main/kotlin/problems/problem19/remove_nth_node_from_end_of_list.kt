package problems.problem19

fun main() {
    val head = ListNode(1)
    println(Solution().removeNthFromEnd(head, 1))
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        return "$`val`, $next"
    }
}

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val newHead = ListNode(0)
        newHead.next = head
        var node1: ListNode? = newHead
        var node2: ListNode? = newHead
        node2?.next = head
        for (i in 0..n) {
            node1 = node1?.next
        }

        while (node1 != null) {
            node1 = node1.next
            node2 = node2?.next
        }
        node2?.let {
            it.next = it.next?.next
        }
        return newHead.next
    }
}