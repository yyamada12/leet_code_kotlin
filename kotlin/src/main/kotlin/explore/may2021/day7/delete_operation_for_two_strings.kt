package explore.may2021.day7

import java.lang.Integer.max

class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val l1 = word1.length
        val l2 = word2.length
        val dp = Array(l1 + 1) { IntArray(l2 + 1) }
        for ((i, c1) in word1.withIndex()) {
            for ((j, c2) in word2.withIndex()) {
                if (c1 == c2) {
                    dp[i + 1][j + 1] = dp[i][j] + 1
                } else {
                    dp[i + 1][j + 1] = max(dp[i][j + 1], dp[i + 1][j])
                }
            }
        }
        return l1 + l2 - 2 * dp[l1][l2]
    }
}

