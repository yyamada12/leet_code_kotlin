package explore.september2021.day4

class Solution {
    fun sumOfDistancesInTree(n: Int, edges: Array<IntArray>): IntArray {
        val ans = IntArray(n)

        val memo =
            mutableMapOf<Int, MutableMap<Int, Pair<Int, Int>>>() // Pair<Int, Int> : num of nodes, sum of distance
        val memo2 = mutableMapOf<Int, Pair<Int, Int>>()
        val tree = List(n) { mutableListOf<Int>() }
        for ((a, b) in edges) {
            tree[a].add(b)
            tree[b].add(a)
        }
        fun dfs(crt: Int, prv: Int): Pair<Int, Int> {
            memo[crt] = mutableMapOf()
            var res = Pair(1, 0)
            for (node in tree[crt]) {
                if (node != prv) {
                    val r = dfs(node, crt)
                    memo[crt]!![node] = r
                    res = res.add(r)
                }
            }
            memo2[crt] = res
            return res
        }
        dfs(0, -1)
        fun dfs2(crt: Int, prv: Int, prt: Pair<Int, Int>) {
            val sum = memo2[crt]!!.add(prt)
            ans[crt] = sum.second
            for (node in tree[crt]) {
                if (node != prv) {
                    dfs2(node, crt, sum.remove(memo[crt]!![node]!!))
                }
            }
        }
        dfs2(0, -1, Pair(0, 0))
        return ans
    }
}

fun Pair<Int, Int>.add(other: Pair<Int, Int>): Pair<Int, Int> {
    return Pair(first + other.first, second + other.second + other.first)
}

fun Pair<Int, Int>.remove(other: Pair<Int, Int>): Pair<Int, Int> {
    return Pair(first - other.first, second - other.second - other.first)
}
