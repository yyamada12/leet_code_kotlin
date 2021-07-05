package explore.july2021.day4

fun main() {
    println(Solution().countVowelPermutation(144))
}

class Solution {
    fun countVowelPermutation(n: Int): Int {
        val dp = Array(n) { IntArray(5) }
        for (j in 0 until 5) {
            dp[0][j] = 1
        }
        for (i in 1 until n) {
            dp[i][0] = dp[i - 1][1] p dp[i - 1][2] p dp[i - 1][4]
            dp[i][1] = dp[i - 1][0] p dp[i - 1][2]
            dp[i][2] = dp[i - 1][1] p dp[i - 1][3]
            dp[i][3] = dp[i - 1][2]
            dp[i][4] = dp[i - 1][2] p dp[i - 1][3]
        }
        return dp[n - 1][0] p dp[n - 1][1] p dp[n - 1][2] p dp[n - 1][3] p dp[n - 1][4]
    }

    private infix fun Int.p(other: Int): Int {
        return (this + other) % 1000000007
    }
}

