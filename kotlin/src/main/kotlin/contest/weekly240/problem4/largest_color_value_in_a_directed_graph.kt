package contest.weekly240.problem4

class Solution {
    fun largestPathValue(colors: String, edges: Array<IntArray>): Int {
        val n = colors.length
        val nodes = (0 until n).map { mutableListOf<Int>() }

        for (edge in edges) {
            nodes[edge[0]].add(edge[1])
        }

        var res = 0
        for (c in 'a'..'z') {
            val visited = BooleanArray(n)
            val finished = BooleanArray(n)
            val memo = IntArray(n)

            fun dfs(i: Int, c: Char): Int {
                if (finished[i]) {
                    return memo[i]
                }
                if (visited[i]) {
                    return -1
                }
                visited[i] = true
                var max = 0
                for (node in nodes[i]) {
                    val r = dfs(node, c)
                    if (r == -1) {
                        return -1
                    }
                    if (max < r) {
                        max = r
                    }
                }
                memo[i] = if (colors[i] == c) {
                    max + 1
                } else {
                    max
                }
                finished[i] = true
                return memo[i]
            }
            for (i in 0 until n) {
                val r = dfs(i, c)
                if (r == -1) {
                    return -1
                }
                if (res < r) {
                    res = r
                }
            }
        }
        return res
    }
}