package explore.june2021.day25

class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val uf = UnionFind(edges.size)
        for ((a, b) in edges) {
            if (uf.same(a - 1, b - 1)) {
                return intArrayOf(a, b)
            }
            uf.unite(a - 1, b - 1)
        }
        return edges.last()
    }

    class UnionFind(val n: Int) {
        val par: IntArray = IntArray(n) { it }
        val rk: IntArray = IntArray(n)

        private fun find(x: Int): Int {
            return if (par[x] == x) x else find(par[x])
        }

        fun unite(x: Int, y: Int) {
            val px = find(x)
            val py = find(y)
            if (px == py) {
                return
            }
            if (rk[px] < rk[py]) {
                par[px] = py
            } else {
                par[py] = px
                if (rk[px] == rk[py]) {
                    rk[px]++
                }
            }
        }

        fun same(x: Int, y: Int): Boolean {
            return find(x) == find(y)
        }
    }
}