package problems.problem6

class Solution {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) return s
        val strs = (0..numRows).map { java.lang.StringBuilder() }
        for ((i, c) in s.withIndex()) {
            val n = i % (numRows * 2 - 2)
            if (n < numRows) {
                strs[n].append(c)
            } else {
                strs[numRows * 2 - 2 - n].append(c)
            }
        }
        return strs.reduce { all, stringBuilder -> all.append(stringBuilder) }.toString()
    }
}