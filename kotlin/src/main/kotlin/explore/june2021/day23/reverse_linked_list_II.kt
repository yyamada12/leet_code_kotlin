package explore.june2021.day23

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        val prvHeadNode = ListNode(0)
        prvHeadNode.next = head
        var prv: ListNode = prvHeadNode
        var crt = head!!
        var next: ListNode?
        for (i in 2..left) {
            prv = crt
            crt = crt.next!! // left < N
        }
        val prvLeftNode = prv
        val leftNode = crt
        next = crt.next

        for (i in left until right) {
            // next step
            prv = crt
            crt = next!! // right <= N
            next = crt.next

            // reverse link
            crt.next = prv
        }

        prvLeftNode.next = crt
        leftNode.next = next
        return prvHeadNode.next
    }
}