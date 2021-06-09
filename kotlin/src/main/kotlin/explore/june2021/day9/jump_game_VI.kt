package explore.june2021.day9

import java.util.*

class Solution {
    fun maxResult(nums: IntArray, k: Int): Int {
        if (nums.size == 1) {
            return nums[0]
        }
        val q = PriorityQueue { i1: Pair<Int, Int>, i2: Pair<Int, Int> -> i2.first - i1.first }
        q.add(nums[nums.size - 1] to nums.size - 1)
        for (i in nums.size - 2 downTo 1) {
            while (q.peek().second > i + k) {
                q.remove()
            }
            q.add(nums[i] + q.peek().first to i)
        }
        while (q.peek().second > k) {
            q.remove()
        }
        return nums[0] + q.peek().first
    }
}