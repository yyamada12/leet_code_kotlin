package explore.september2021.day19

fun main() {
    println(Solution().numDistinct("babgbag", "bag"))
}

class Solution {
    fun numDistinct(s: String, t: String): Int {
        val dp = IntArray(t.length + 1)
        dp[0] = 1
        for (c in s) {
            for (i in t.length - 1 downTo 0) {
                if (c == t[i]) {
                    dp[i + 1] += dp[i]
                }
            }
        }
        return dp[t.length]
    }
}
