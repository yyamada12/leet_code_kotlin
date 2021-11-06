package explore.november2021.day6


class Solution {
    fun singleNumber(nums: IntArray): IntArray {
        val m = mutableSetOf<Int>()
        for (n in nums) {
            if (m.contains(n)) {
                m.remove(n)
            } else {
                m.add(n)
            }
        }
        return m.toIntArray()
    }
}
