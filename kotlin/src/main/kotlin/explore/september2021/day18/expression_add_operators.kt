package explore.september2021.day18

fun main() {
    println(Solution().addOperators("105", 5))
}

class Solution {
    enum class OPERATION {
        ADD, SUB
    }

    fun addOperators(num: String, target: Int): List<String> {
        val res = mutableListOf<String>()
        fun dfs(i: Int, expr: String, l: Long, r: Long, last: OPERATION, tail: Long) {
            val result = when (last) {
                OPERATION.ADD -> l + r
                OPERATION.SUB -> l - r
            }
            if (i == num.length) {
                if (result == target.toLong()) {
                    res.add(expr)
                }
                return
            }

            val v = (num[i] - '0').toLong()
            dfs(i + 1, "$expr+${num[i]}", result, v, OPERATION.ADD, v) // +
            dfs(i + 1, "$expr-${num[i]}", result, v, OPERATION.SUB, v) // -
            dfs(i + 1, "$expr*${num[i]}", l, r * v, last, v) // *
            if (tail != 0L) {
                dfs(i + 1, "$expr${num[i]}", l, r / tail * (tail * 10 + v), last, tail * 10 + v) // no ope
            }
        }

        fun dfs(i: Int, expr: String, result: Long, tail: Long) {
            if (i == num.length) {
                if (result == target.toLong()) {
                    res.add(expr)
                }
                return
            }
            val v = (num[i] - '0').toLong()
            dfs(i + 1, "$expr+${num[i]}", result, v, OPERATION.ADD, v) // +
            dfs(i + 1, "$expr-${num[i]}", result, v, OPERATION.SUB, v) // -
            dfs(i + 1, "$expr*${num[i]}", result * v, v) // *
            if (tail != 0L) {
                dfs(i + 1, "$expr${num[i]}", result / tail * (tail * 10 + v), tail * 10 + v) // no ope
            }
        }

        val v = (num[0] - '0').toLong()
        dfs(1, num[0].toString(), v, v)
        return res
    }
}
