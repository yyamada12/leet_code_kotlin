package explore.may2021.day4

fun main() {
    println(Solution().checkPossibility(intArrayOf(4, 3, 2)))
}

class Solution {
    fun checkPossibility(nums: IntArray): Boolean {
        val l = nums.size
        var modified = false
        for (i in 0..l - 2) {
            if (nums[i] > nums[i + 1]) {
                if (modified) {
                    return false
                }

                if (i == 0 || i == l - 2 || nums[i - 1] <= nums[i + 1] || nums[i] <= nums[i + 2]) {
                    modified = true
                    continue
                }
                return false
            }
        }
        return true
    }
}