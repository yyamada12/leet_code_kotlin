package explore.september2021.day29

fun main() {
    val head = ListNode(1)
    var crt = head
    for (i in 2..10) {
        val nxt = ListNode(i)
        crt.next = nxt
        crt = nxt
    }
    val ans = Solution().splitListToParts(head, 3)
    ans.forEach { println(it) }

}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        var crt: ListNode? = this
        var res = ""
        while (crt != null) {
            res += "${crt.`val`},"
            crt = crt.next
        }
        return "[$res]"
    }
}

class Solution {
    fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
        val n = sizeOf(head)

        val res = Array<ListNode?>(k) { null }

        var prv = ListNode(0)
        prv.next = head
        var crt = head

        if (n < k) {
            var i = 0
            while (crt != null) {
                res[i] = crt
                prv.next = null
                prv = crt
                crt = crt.next
                i++
            }
            return res
        }

        for (i in 0 until k) {
            res[i] = crt
            if (i < n % k) {
                prv = crt!!.next(n / k)!!
                crt = prv.next
                prv.next = null
            } else {
                prv = crt!!.next(n / k - 1)!!
                crt = prv.next
                prv.next = null
            }
        }
        return res
    }

    private fun sizeOf(node: ListNode?): Int {
        var n = 0
        var crt = node
        while (crt != null) {
            crt = crt.next
            n++
        }
        return n
    }

    fun ListNode.next(n: Int): ListNode? {
        var crt: ListNode? = this
        for (_i in 0 until n) {
            crt = crt!!.next
        }
        return crt
    }
}
