package contest.weekly240.problem2

fun main() {
    println(Solution().maxDistance(intArrayOf(55, 30, 5, 4, 2), intArrayOf(100, 20, 10, 10, 5)))
    println(Solution().maxDistance(intArrayOf(2, 2, 2), intArrayOf(10, 10, 1)))
    println(Solution().maxDistance(intArrayOf(30, 29, 19, 5), intArrayOf(25, 25, 25, 25, 25)))
    println(Solution().maxDistance(intArrayOf(5, 4), intArrayOf(3, 2)))
}

class Solution {
    fun maxDistance(nums1: IntArray, nums2: IntArray): Int {
        var i = 0
        var j = 0
        val l1 = nums1.size
        val l2 = nums2.size
        var res = 0
        while (i < l1 && j < l2) {
            if (nums1[i] > nums2[j]) {
                i++
            } else {
                if (res < j - i) {
                    res = j - i
                }
                j++
            }
        }
        return res
    }
}