package explore.september2021.day17

class Solution {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val m = mutableMapOf<Int, Int>()
        nums1.forEach {
            val v = m[it] ?: 0
            m[it] = v + 1
        }
        val res = mutableListOf<Int>()
        for (num in nums2) {
            val v = m[num] ?: 0
            if (v > 0) {
                m[num] = v - 1
                res.add(num)
            }
        }
        return res.toIntArray()
    }
}
