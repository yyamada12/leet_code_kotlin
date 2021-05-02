package problems.problem13

class Solution {
    fun romanToInt(s: String): Int {
        val l = s.length
        var res = 0
        for ((i, c) in s.withIndex()) {
            res += when (c) {
                'I' -> {
                    if (i + 1 < l && (s[i + 1] == 'V' || s[i + 1] == 'X')) {
                        -1
                    } else {
                        1
                    }
                }
                'V' -> 5
                'X' -> {
                    if (i + 1 < l && (s[i + 1] == 'L' || s[i + 1] == 'C')) {
                        -10
                    } else {
                        10
                    }
                }
                'L' -> 50
                'C' -> {
                    if (i + 1 < l && (s[i + 1] == 'D' || s[i + 1] == 'M')) {
                        -100
                    } else {
                        100
                    }
                }
                'D' -> 500
                'M' -> 1000
                else -> 0
            }
        }
        return res
    }
}