package explore.may2021.day3

class Solution {
    fun runningSum(nums: IntArray): IntArray {
        for (i in nums.indices) {
            if (i > 0) {
                nums[i] += nums[i - 1]
            }
        }
        return nums
    }
}