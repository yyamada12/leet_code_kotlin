package explore.november2021.day11

class Solution {
    fun minStartValue(nums: IntArray): Int {
        var mi = 0
        var s = 0
        for (n in nums) {
            s += n
            mi = mi.coerceAtMost(s)
        }
        return 1 - mi
    }
}

