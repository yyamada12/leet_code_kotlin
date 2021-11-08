package explore.november2021.day8

fun main() {
    println(Solution().numTrees(3))
}

class Solution {
    fun numTrees(n: Int): Int {
        val memo = IntArray(20) { 0 }
        memo[0] = 1
        fun dfs(n: Int): Int {
            if (memo[n] > 0) {
                return memo[n]
            }
            var res = 0
            for (i in 0 until n) {
                res += dfs(i) * dfs(n - i - 1)
            }
            memo[n] = res
            return res
        }
        return dfs(n)
    }
}
