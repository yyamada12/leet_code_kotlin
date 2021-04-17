package problem2

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var carry = 0
        val ans = ListNode(0)
        var crt: ListNode? = ans

        var ln1 = l1
        var ln2 = l2
        while (true) {
            val v1 = ln1?.`val`
            val v2 = ln2?.`val`

            if (v1 == null && v2 == null) {
                if (carry > 0) {
                    crt?.next = ListNode(carry)
                }
                return ans.next
            }

            val sum = ((v1 ?: 0) + (v2 ?: 0) + carry)
            carry = sum / 10
            crt?.next = ListNode(sum % 10)
            crt = crt?.next

            ln1 = ln1?.next
            ln2 = ln2?.next
        }


    }
}