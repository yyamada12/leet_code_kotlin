package explore.november2021.day12


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        val root = ListNode(0)
        root.next = head

        var prv = root
        var node = head

        while (node != null) {
            if (node.`val` == `val`) {
                prv.next = node.next
            } else {
                prv = node
            }
            node = node.next
        }
        return root.next
    }
}
