package problems.problem1


class Solution {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val h = hashMapOf<Int, Int>()
        for ((i, v) in nums.withIndex()) {
            val j = h[target - v]
            if (j != null) {
                return intArrayOf(i, j)
            }
            h[v] = i
        }
        throw IllegalArgumentException()
    }
}
