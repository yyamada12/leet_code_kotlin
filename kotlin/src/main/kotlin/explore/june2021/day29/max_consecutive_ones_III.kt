package explore.june2021.day29

fun main() {
    println(Solution().longestOnes(intArrayOf(0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1), 3))
}

class Solution {
    fun longestOnes(nums: IntArray, k: Int): Int {
        var res = 0
        var zeros = 0
        var s = 0
        for ((e, n) in nums.withIndex()) {
            if (n == 0) {
                zeros++
            }
            while (zeros > k) {
                if (nums[s] == 0) zeros--
                s++
            }
            res = max(res, e - s + 1)
        }
        return res
    }
}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}
