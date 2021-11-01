package explore.november2021.day1

fun main() {
    val board = arrayOf(
        charArrayOf('X', 'X', 'X', 'X'),
        charArrayOf('X', 'O', 'O', 'X'),
        charArrayOf('X', 'X', 'O', 'X'),
        charArrayOf('X', 'O', 'X', 'X')
    )
    Solution().solve(board)
    for (row in board) {
        for (c in row) {
            print(c)
            print(",")
        }
        println()
    }
}

class Solution {
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(1, 0, -1, 0)
    fun solve(board: Array<CharArray>): Unit {
        val m = board.size
        val n = board[0].size
        val checked = Array(m) { BooleanArray(n) { false } }
        fun dfs(i: Int, j: Int) {
            if (i < 0 || i >= m || j < 0 || j >= n || checked[i][j] || board[i][j] == 'X') {
                return
            }
            checked[i][j] = true
            for (d in 0 until 4) {
                dfs(i + dx[d], j + dy[d])
            }
        }

        for (i in 0 until m) {
            if (i == 0 || i == m - 1) {
                for (j in 0 until n) {
                    dfs(i, j)
                }
            } else {
                dfs(i, 0)
                dfs(i, n - 1)
            }
        }
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (!checked[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X'
                }
            }
        }
    }
}
