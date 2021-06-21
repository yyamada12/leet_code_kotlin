package explore.june2021.day20

fun main() {
    println(
        Solution().swimInWater(
            arrayOf(
                intArrayOf(7, 34, 16, 12, 15, 0),
                intArrayOf(10, 26, 4, 30, 1, 20),
                intArrayOf(28, 27, 33, 35, 3, 8),
                intArrayOf(29, 9, 13, 14, 11, 32),
                intArrayOf(31, 21, 23, 24, 19, 18),
                intArrayOf(22, 6, 17, 5, 2, 25)
            )
        )
    )
}

class Solution {
    fun search(grid: Array<IntArray>, depth: Int): Boolean {
        if (depth < grid[0][0]) {
            return false
        }
        val n = grid.size
        val seen = Array(n) { BooleanArray(n) }
        fun dfs(i: Int, j: Int): Boolean {
            seen[i][j] = true
            if (i == n - 1 && j == n - 1) {
                return true
            }
            var res = false
            for (d in 0 until 4) {
                val di = i + dx[d]
                val dj = j + dy[d]
                if (di in 0 until n && dj in 0 until n && !seen[di][dj] && grid[di][dj] <= depth) {
                    res = res || dfs(di, dj)
                }
            }
            return res
        }
        return dfs(0, 0)
    }

    fun swimInWater(grid: Array<IntArray>): Int {
        val n = grid.size
        var res = Int.MAX_VALUE
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (search(grid, grid[i][j])) {
                    res = min(res, grid[i][j])
                }
            }
        }
        return res
    }
}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun min(a: Int, b: Int): Int {
    return if (a < b) a else b
}

val dx = intArrayOf(0, 1, 0, -1)
val dy = intArrayOf(1, 0, -1, 0)