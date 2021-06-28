package explore.june2021.day27

class Solution {
    fun candy(ratings: IntArray): Int {
        val n = ratings.size
        val left = IntArray(n)
        val right = IntArray(n)
        left[0] = 1
        right[n - 1] = 1
        for (i in 1 until n) {
            left[i] = if (ratings[i] > ratings[i - 1]) {
                left[i - 1] + 1
            } else 1
        }
        for (i in n - 2 downTo 0) {
            right[i] = if (ratings[i] > ratings[i + 1]) {
                right[i + 1] + 1
            } else 1
        }
        var res = 0
        for (i in 0 until n) {
            res += max(left[i], right[i])
        }
        return res
    }
}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}