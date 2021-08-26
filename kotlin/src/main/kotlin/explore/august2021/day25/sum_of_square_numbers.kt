package explore.august2021.day25

class Solution {
    fun judgeSquareSum(c: Int): Boolean {
        var a = 0
        var b = 1L shl 16
        while (a <= b) {
            val s = a * a + b * b
            if (s == c.toLong()) {
                return true
            }
            if (s < c) {
                a++
            } else {
                b--
            }
        }
        return false
    }
}