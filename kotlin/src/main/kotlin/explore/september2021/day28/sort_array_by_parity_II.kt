package explore.september2021.day28

class Solution {
    fun sortArrayByParityII(nums: IntArray): IntArray {
        val n = nums.size
        var j = 1
        for (i in 0 until n step 2) {
            if (nums[i] % 2 != 0) {
                while (j < n && nums[j] % 2 == 1) {
                    j += 2
                }
                val tmp = nums[i]
                nums[i] = nums[j]
                nums[j] = tmp
            }
        }
        return nums
    }
}
