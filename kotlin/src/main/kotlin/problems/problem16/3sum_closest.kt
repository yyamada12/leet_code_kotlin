package problems.problem16

class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        fun closer(a: Int, b: Int): Int {
            if (Math.abs(target - a) > Math.abs(target - b)) {
                return b
            }
            return a
        }

        var res = nums[0] + nums[1] + nums[2]
        for (i in 0..(nums.size - 3)) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue
            }
            for (j in (i + 1)..(nums.size - 2)) {
                if (j > (i + 1) && nums[j - 1] == nums[j]) {
                    continue
                }
                val k = nums.binarySearch(target - nums[i] - nums[j], j + 1)
                if (k > 0) {
                    return target
                } else {
                    val h = -k - 1
                    val l = h - 1
                    if (l > j) {
                        res = closer(res, nums[i] + nums[j] + nums[l])
                    }
                    if (h < nums.size) {
                        res = closer(res, nums[i] + nums[j] + nums[h])
                    }
                }
            }
        }
        return res
    }
}