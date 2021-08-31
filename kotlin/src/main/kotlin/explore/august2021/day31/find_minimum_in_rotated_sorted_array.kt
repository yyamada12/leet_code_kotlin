package explore.august2021.day31

fun main() {
    println(Solution().findMin(intArrayOf(11, 13, 15, 17)))
}

class Solution {
    fun findMin(nums: IntArray): Int {
        if (nums.size == 1 || nums.first() < nums.last()) {
            return nums.first()
        }

        var l = 0
        var r = nums.size - 1
        while (r - l > 1) {
            val mid = (l + r) / 2
            if (nums[mid] > nums[l]) {
                l = mid
            } else {
                r = mid
            }
        }
        return nums[r]
    }
}
