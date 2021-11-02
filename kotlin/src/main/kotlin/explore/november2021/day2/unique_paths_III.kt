package explore.november2021.day2

class Solution {
    fun uniquePathsIII(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        fun dfs(x: Int, y: Int): Int {
            if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == -1) {
                return 0
            }
            if (grid[x][y] == 2) {
                return if (!grid.any { row -> row.any { it == 0 } }) 1 else 0
            }
            grid[x][y] = -1
            val res = dfs(x + 1, y) + dfs(x, y + 1) + dfs(x - 1, y) + dfs(x, y - 1)
            grid[x][y] = 0
            return res
        }
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 1) {
                    return dfs(i, j)
                }
            }
        }
        return 0
    }
}
