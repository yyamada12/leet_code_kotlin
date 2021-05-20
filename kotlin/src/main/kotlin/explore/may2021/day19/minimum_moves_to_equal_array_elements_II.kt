package explore.may2021.day19

import kotlin.math.abs

class Solution {
    fun minMoves2(nums: IntArray): Int {
        nums.sort()
        val middle = nums[nums.size / 2]
        return nums.map { abs(middle - it) }.sum()
    }
}