package problem4

fun main() {
    println(Solution().findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)))
}

class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val merged = IntArray(nums1.size + nums2.size)
        var i = 0
        var j = 0
        val l1 = nums1.size
        val l2 = nums2.size
        while (i < l1 || j < l2) {
            if (j == l2 || (i != l1 && nums1[i] < nums2[j])) {
                merged[i + j] = nums1[i]
                i++
            } else {
                merged[i + j] = nums2[j]
                j++
            }
        }
        if ((l1 + l2) % 2 == 1) {
            return merged[(l1 + l2) / 2].toDouble()
        }
        return (merged[(l1 + l2) / 2].toDouble() + merged[(l1 + l2) / 2 - 1].toDouble()) / 2.0
    }
}