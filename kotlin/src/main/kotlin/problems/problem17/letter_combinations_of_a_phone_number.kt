package problems.problem17

class Solution {
    fun letterCombinations(digits: String): List<String> {
        if (digits == "") {
            return listOf()
        }
        fun convert(c: Char): List<Char> {
            return when (c) {
                '2' -> listOf('a', 'b', 'c')
                '3' -> listOf('d', 'e', 'f')
                '4' -> listOf('g', 'h', 'i')
                '5' -> listOf('j', 'k', 'l')
                '6' -> listOf('n', 'm', 'o')
                '7' -> listOf('p', 'q', 'r', 's')
                '8' -> listOf('t', 'u', 'v')
                '9' -> listOf('w', 'x', 'y', 'z')
                else -> throw IllegalArgumentException()
            }
        }

        var res = listOf("")
        for (c in digits) {
            val alphas = convert(c)
            res = res.map { e -> alphas.map { alpha -> e + alpha } }.flatten()
        }
        return res
    }
}