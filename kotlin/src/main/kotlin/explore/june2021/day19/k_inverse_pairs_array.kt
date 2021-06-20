package explore.june2021.day19

fun main() {
    println(Solution().kInversePairs(3, 1))
}

class Solution {
    fun kInversePairs(n: Int, k: Int): Int {
        val dp = Array(n + 1) { IntArray(k + 1) }
        dp[0][0] = 1
        for (i in 1..n) {
            for (j in 0..k) {
                for (d in 0 until i) {
                    if (j - d >= 0) {
                        dp[i][j] += dp[i - 1][j - d]
                        dp[i][j] %= 1000000007
                    }
                }
            }
        }
        return dp[n][k]
    }
}