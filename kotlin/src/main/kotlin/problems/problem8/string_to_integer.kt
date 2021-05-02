package problems.problem8

fun main() {
    println((Solution().myAtoi("-2147483647")))
}

class Solution {
    fun myAtoi(s: String): Int {
        val l = s.length
        var i = 0
        var res = 0L
        var isNegative = false
        while (i < l && s[i] == ' ') {
            i++
        }
        if (i < l && s[i] == '+') {
            i++
        } else if (i < l && s[i] == '-') {
            i++
            isNegative = true
        }
        while (i < l && s[i] == '0') {
            i++
        }

        while (i < l) {
            if (s[i] !in '0'..'9') {
                break
            }
            res = res * 10 + (s[i] - '0')
            if (isNegative && -res <= Int.MIN_VALUE) {
                return Int.MIN_VALUE
            } else if (!isNegative && res >= Int.MAX_VALUE) {
                return Int.MAX_VALUE
            }
            i++
        }

        return if (isNegative) -res.toInt() else res.toInt()
    }
}