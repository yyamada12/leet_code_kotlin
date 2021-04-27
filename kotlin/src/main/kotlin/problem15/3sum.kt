package problem15

class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val res = mutableListOf<List<Int>>()
        for (i in 0..(nums.size - 3)) {
            if (nums[i] > 0) {
                return res
            }
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue
            }
            for (j in (i + 1)..(nums.size - 2)) {
                if (j > (i + 1) && nums[j - 1] == nums[j]) {
                    continue
                }
                val k = nums.binarySearch(-nums[i] - nums[j], j + 1)
                if (k > 0) {
                    res.add(listOf(nums[i], nums[j], nums[k]))
                }
            }
        }
        return res
    }
}