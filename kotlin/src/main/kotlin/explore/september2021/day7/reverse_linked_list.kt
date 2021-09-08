package explore.september2021.day7

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var prv: ListNode? = null
        var crt = head
        while (crt != null) {
            val nxt = crt.next
            crt.next = prv
            prv = crt
            crt = nxt
        }
        return prv
    }
}
