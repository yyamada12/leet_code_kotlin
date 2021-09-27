package explore.september2021.day26

fun main() {
    println(
        Solution().movesToChessboard(
            arrayOf(
                intArrayOf(0, 1, 1),
                intArrayOf(1, 0, 0),
                intArrayOf(0, 1, 1)
            )
        )
    )
}


class Solution {
    fun movesToChessboard(board: Array<IntArray>): Int {
        val n = board.size
        val rows = mutableListOf<Boolean>()
        val cols = mutableListOf<Boolean>()
        for (i in 0 until n) {
            var ct = 0
            for (j in 0 until n) {
                if (board[i][j] == board[0][j]) {
                    ct++
                }
            }
            if (ct != n && ct != 0) {
                return -1
            }
            rows.add(ct == n)
        }
        for (j in 0 until n) {
            var ct = 0
            for (i in 0 until n) {
                if (board[i][j] == board[i][0]) {
                    ct++
                }
            }
            if (ct != n && ct != 0) {
                return -1
            }
            cols.add(ct == n)
        }
        val cntr = rows.count { it }
        val cntc = cols.count { it }
        if (n % 2 == 0) {
            if (cntr != n / 2 || cntc != n / 2) {
                return -1
            }
            val hamr = rows.mapIndexed { i, b -> (i % 2 == 0) != b }.count { it }
            val hamc = cols.mapIndexed { i, b -> (i % 2 == 0) != b }.count { it }
            return Math.min(hamr, n - hamr) / 2 + Math.min(hamc, n - hamc) / 2
        } else {
            val hamr = when (cntr) {
                n / 2 -> rows.mapIndexed { i, b -> (i % 2 != 0) != b }.count { it }
                n / 2 + 1 -> rows.mapIndexed { i, b -> (i % 2 == 0) != b }.count { it }
                else -> return -1
            }
            val hamc = when (cntc) {
                n / 2 -> cols.mapIndexed { i, b -> (i % 2 != 0) != b }.count { it }
                n / 2 + 1 -> cols.mapIndexed { i, b -> (i % 2 == 0) != b }.count { it }
                else -> return -1
            }
            return hamr / 2 + hamc / 2
        }
    }
}
