package contest.weekly242.problem4

// Wrong Answer
class Solution {
    fun stoneGameVIII(stones: IntArray): Int {
        if (stones.size == 2) {
            return stones.sum()
        }
        val sum = stones.sum()
        val last = -stones[stones.size - 1]
        return if (sum > last) sum else last
    }
}