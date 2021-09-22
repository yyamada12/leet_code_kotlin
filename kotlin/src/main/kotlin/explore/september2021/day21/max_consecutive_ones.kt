package explore.september2021.day21


class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var ct = 0
        var res = 0
        for (num in nums) {
            if (num == 0) {
                res = Math.max(res, ct)
                ct = 0
            } else {
                ct++
            }
        }
        return Math.max(res, ct)
    }
}
