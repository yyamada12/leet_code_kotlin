package explore.august2021.day29

fun main() {
    println(Solution().minPatches(intArrayOf(1, 2, 31, 33), 2147483647))
}

class Solution {
    fun minPatches(nums: IntArray, n: Int): Int {
        var s = 0L
        var res = 0
        if (nums[0] != 1) {
            s += 1
            res++
        }
        for (num in nums) {
            while (num > s + 1 && n > s) {
                s += s + 1
                res++
            }
            if (n <= s) {
                return res
            }
            s += num
        }
        while (n > s) {
            s += s + 1
            res++
        }
        return res
    }
}
