package explore.june2021.day17

class Solution {
    fun numSubarrayBoundedMax(nums: IntArray, left: Int, right: Int): Int {
        var s = 0
        var m = -1
        var res = 0
        for ((i, num) in nums.withIndex()) {
            if (num < left) {
                if (m != -1) {
                    res += m - s + 1
                }
            } else if (num <= right) {
                m = i
                res += m - s + 1
            } else {
                s = i + 1
                m = -1
            }
        }
        return res
    }
}