package explore.june2021.day16

class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val res = mutableListOf<String>()
        fun dfs(l: Int, r: Int, str: String) {
            if (l == n && r == n) {
                res.add(str)
                return
            }
            if (l > r) {
                dfs(l, r + 1, str + ")")
            }
            if (l != n) {
                dfs(l + 1, r, str + "(")
            }
        }
        dfs(0, 0, "")
        return res
    }
}