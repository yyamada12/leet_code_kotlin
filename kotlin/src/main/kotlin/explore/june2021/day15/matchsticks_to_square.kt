package explore.june2021.day15

class Solution {
    fun makesquare(matchsticks: IntArray): Boolean {
        val len = matchsticks.map { it.toLong() }.sum() / 4
        fun dfs(i: Int, l1: Long, l2: Long, l3: Long, l4: Long): Boolean {
            if (i == matchsticks.size) {
                return l1 == l2 && l2 == l3 && l3 == l4
            }
            if (l1 > len || l2 > len || l3 > len || l4 > len) {
                return false
            }
            val crt = matchsticks[i]
            return dfs(i + 1, l1 + crt, l2, l3, l4) ||
                    dfs(i + 1, l1, l2 + crt, l3, l4) ||
                    dfs(i + 1, l1, l2, l3 + crt, l4) ||
                    dfs(i + 1, l1, l2, l3, l4 + crt)
        }
        return dfs(1, matchsticks[0].toLong(), 0, 0, 0)
    }
}