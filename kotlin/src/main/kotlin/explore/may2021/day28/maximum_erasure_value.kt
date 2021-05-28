package explore.may2021.day28

class Solution {
    fun maximumUniqueSubarray(nums: IntArray): Int {
        val l = nums.size
        var start = 0
        var end = 0
        val seen = mutableSetOf<Int>()

        var sum = 0
        var res = 0
        while (true) {
            while (end < l && !seen.contains(nums[end])) {
                seen.add(nums[end])
                sum += nums[end]
                end++
            }
            if (res < sum) {
                res = sum
            }
            if (end == l) {
                break
            }

            while (true) {
                seen.remove(nums[start])
                sum -= nums[start]
                start++
                if (nums[start - 1] == nums[end]) {
                    break
                }
            }
        }
        return res
    }
}