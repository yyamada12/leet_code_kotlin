package explore.june2021.day6

class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        nums.sort()
        var prv = Int.MIN_VALUE
        var seq = 0
        var res = 0
        for (n in nums) {
            if (n == prv) {
                continue
            }
            if (n == prv + 1) {
                seq++
            } else {
                if (res < seq) {
                    res = seq
                }
                seq = 1
            }
            prv = n
        }
        if (res < seq) {
            res = seq
        }
        return res
    }
}