package problem7

fun main() {
    println(Solution().reverse(123))
}

internal class Solution {
    fun reverse(x: Int): Int {
        var tmp: Long = x.toLong()
        var res = 0L
        while(tmp != 0L) {
            res = res * 10 + tmp % 10
            tmp /= 10
        }
        if (res in Int.MIN_VALUE..Int.MAX_VALUE) {
            return res.toInt()
        }
        return 0
    }
}