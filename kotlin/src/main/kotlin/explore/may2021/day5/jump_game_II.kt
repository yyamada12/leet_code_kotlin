package explore.may2021.day5

class Solution {
    fun jump(nums: IntArray): Int {
        val l = nums.size
        val dp = IntArray(l)
        dp[l - 1] = 0
        for (i in l - 2 downTo 0) {
            dp[i] = 1000
            for (j in 1..nums[i]) {
                val dst = i + j
                if (dst >= l) {
                    break
                }
                dp[i] = min(dp[i], dp[dst] + 1)
            }
        }
        return dp[0]
    }
}

fun min(a: Int, b: Int): Int {
    return if (a < b) a else b
}