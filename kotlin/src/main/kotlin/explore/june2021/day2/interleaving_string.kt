package explore.june2021.day2

fun main() {
    println(Solution().isInterleave("aabcc", "dbbca", "aadbbbaccc"))
}

class Solution {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        val l1 = s1.length
        val l2 = s2.length
        if (s3.length != l1 + l2) {
            return false
        }
        val memo = Array(l1 + 1) { IntArray(l2 + 1) }
        fun dfs(i: Int, j: Int): Boolean {
            if (memo[i][j] != 0) {
                return memo[i][j] == 1
            }
            if (i == l1 && j == l2) {
                memo[i][j] = 1
                return true
            }
            var res = false
            if (i < l1 && s1[i] == s3[i + j]) {
                res = dfs(i + 1, j) || res
            }
            if (j < l2 && s2[j] == s3[i + j]) {
                res = dfs(i, j + 1) || res
            }
            memo[i][j] = if (res) 1 else -1
            return res
        }
        return dfs(0, 0)
    }
}