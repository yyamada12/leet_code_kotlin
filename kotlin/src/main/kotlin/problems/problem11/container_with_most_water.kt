package problems.problem11

fun main() {
    println(Solution().maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
}

class Solution {
    fun maxArea(height: IntArray): Int {

        var l = 0
        var r = height.size - 1
        var res = 0
        while (l < r) {
            val lh = height[l]
            val rh = height[r]
            if (lh < rh) {
                res = max(res, lh * (r - l))
                while (l < r && lh >= height[l]) {
                    l++
                }
            } else {
                res = max(res, rh * (r - l))
                while (l < r && rh >= height[r]) {
                    r--
                }
            }
        }
        return res
    }
}

fun max(a: Int, b: Int): Int {
    if (a > b) {
        return a
    }
    return b
}