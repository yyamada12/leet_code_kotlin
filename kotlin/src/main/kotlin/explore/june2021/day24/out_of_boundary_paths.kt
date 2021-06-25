package explore.june2021.day24

class Solution {
    fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {
        if (maxMove == 0) {
            return 0
        }
        val dp = Array(maxMove) { Array(m) { IntArray(n) } }
        dp[0][startRow][startColumn] = 1
        var res = 0
        if (startRow == 0) {
            res++
        }
        if (startColumn == 0) {
            res++
        }
        if (startRow == m - 1) {
            res++
        }
        if (startColumn == n - 1) {
            res++
        }
        for (move in 1 until maxMove) {
            for (i in 0 until m) {
                for (j in 0 until n) {
                    for (d in 0 until 4) {
                        val di = i + dx[d]
                        val dj = j + dy[d]
                        if (di in 0 until m && dj in 0 until n) {
                            dp[move][i][j] += dp[move - 1][di][dj]
                            dp[move][i][j] %= 1000000007
                        }
                    }
                }
            }
            for (i in 0 until m) {
                res += dp[move][i][0]
                res %= 1000000007
                res += dp[move][i][n - 1]
                res %= 1000000007
            }
            for (j in 0 until n) {
                res += dp[move][0][j]
                res %= 1000000007
                res += dp[move][m - 1][j]
                res %= 1000000007
            }
        }
        return res
    }
}

val dx = intArrayOf(0, 1, 0, -1)
val dy = intArrayOf(1, 0, -1, 0)