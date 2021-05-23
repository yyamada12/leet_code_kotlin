package explore.may2021.day22

fun main() {
    val ans = Solution().solveNQueens(7)
    for (l in ans) {
        for (s in l) {
            println(s)
        }
    }
}

class Solution {
    fun solveNQueens(n: Int): List<List<String>> {
        fun dfs(l: MutableList<Int>): List<List<Int>> {
            val crt = l.size
            if (crt == n) {
                return listOf(l)
            }
            val cannot = BooleanArray(n)
            for ((i, e) in l.withIndex()) {
                cannot[e] = true
                if (e - (crt - i) >= 0) {
                    cannot[e - (crt - i)] = true
                }
                if (e + (crt - i) < n) {
                    cannot[e + (crt - i)] = true
                }
            }
            val res = mutableListOf<List<Int>>()
            for ((i, e) in cannot.withIndex()) {
                if (!e) {
                    val ll = l.toMutableList()
                    ll.add(i)
                    res.addAll(dfs(ll))
                }
            }
            return res
        }
        return dfs(mutableListOf()).map {
            it.map {
                (0 until n).fold("") { str, i -> str + if (i == it) "Q" else "." }
            }
        }
    }
}