package explore.may2021.day29

class Solution {
    fun totalNQueens(n: Int): Int {
        fun dfs(l: MutableList<Int>): Int {
            var res = 0
            val crt = l.size
            if (crt == n) {
                return 1
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
            for ((i, e) in cannot.withIndex()) {
                if (!e) {
                    val ll = l.toMutableList()
                    ll.add(i)
                    res += dfs(ll)
                }
            }
            return res
        }
        return dfs(mutableListOf())
    }
}