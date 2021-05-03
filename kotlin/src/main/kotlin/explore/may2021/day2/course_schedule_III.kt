package explore.may2021.day2

fun main() {
    println(
        Solution().scheduleCourse(
            arrayOf(
                intArrayOf(7, 16),
                intArrayOf(2, 3),
                intArrayOf(3, 12),
                intArrayOf(3, 14),
                intArrayOf(10, 19),
                intArrayOf(10, 16),
                intArrayOf(6, 8),
                intArrayOf(6, 11),
                intArrayOf(3, 13),
                intArrayOf(6, 16)
            )
        )
    )
}

class Solution {
    fun scheduleCourse(courses: Array<IntArray>): Int {
        courses.sortBy { arr -> arr[1] }
        val dp = IntArray(10001)
        for (course in courses) {
            val dur = course[0]
            val las = course[1]
            for (i in (las - dur) downTo 0) {
                dp[i + dur] = max(dp[i + dur], dp[i] + 1)
            }
        }
        var res = 0
        for (n in dp) {
            res = max(res, n)
        }
        return res
    }
}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}