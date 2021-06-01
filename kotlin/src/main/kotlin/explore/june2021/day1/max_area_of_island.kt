package explore.june2021.day1

class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        fun dfs(x: Int, y: Int): Int {
            if (x !in 0 until m || y !in 0 until n || grid[x][y] == 0) {
                return 0
            }
            grid[x][y] = 0
            return 1 + dfs(x + 1, y) + dfs(x, y + 1) + dfs(x - 1, y) + dfs(x, y - 1)
        }

        var res = 0
        for (x in 0 until m) {
            for (y in 0 until n) {
                res = max(res, dfs(x, y))
            }
        }
        return res
    }
}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}