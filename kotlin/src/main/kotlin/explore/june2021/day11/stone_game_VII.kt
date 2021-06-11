package explore.june2021.day11

fun main() {
    println(Solution().stoneGameVII(intArrayOf(7, 90, 5, 1, 100, 10, 10, 2)))
}

class Solution {

    private val memo = Array(1000) { IntArray(1000) }
    val sum = IntArray(1001)

    fun stoneGameVII(stones: IntArray): Int {
        val l = stones.size
        for (i in 0 until l) {
            sum[i + 1] = sum[i] + stones[i]
        }
        return alice(0, l - 1)
    }

    private fun alice(left: Int, right: Int): Int {
        if (memo[left][right] != 0) {
            return memo[left][right]
        }
        if (right == left) {
            return 0
        }
        val l = sum[right + 1] - sum[left + 1] + bob(left + 1, right)
        val r = sum[right] - sum[left] + bob(left, right - 1)
        memo[left][right] = if (r > l) r else l
        return memo[left][right]
    }

    private fun bob(left: Int, right: Int): Int {
        if (memo[left][right] != 0) {
            return memo[left][right]
        }
        if (right == left) {
            return 0
        }
        val l = alice(left + 1, right) - (sum[right + 1] - sum[left + 1])
        val r = alice(left, right - 1) - (sum[right] - sum[left])
        memo[left][right] = if (r < l) r else l
        return memo[left][right]
    }
}