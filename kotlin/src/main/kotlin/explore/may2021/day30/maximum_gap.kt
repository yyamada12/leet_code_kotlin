package explore.may2021.day30

import java.util.*

class Solution {
    fun maximumGap(nums: IntArray): Int {
        if (nums.size < 2) {
            return 0
        }
        var mi = Int.MAX_VALUE
        var ma = Int.MIN_VALUE
        for (num in nums) {
            mi = min(num, mi)
            ma = max(num, ma)
        }

        val l = nums.size

        val gap = kotlin.math.ceil((ma - mi).toDouble() / (l - 1)).toInt()
        val min_buckets = IntArray(l - 1)
        val max_buckets = IntArray(l - 1)
        Arrays.fill(min_buckets, Int.MAX_VALUE)
        Arrays.fill(max_buckets, Int.MIN_VALUE)

        for (num in nums) {
            if (num == mi || num == ma) {
                continue
            }
            val crt = (num - mi) / gap
            min_buckets[crt] = min(min_buckets[crt], num)
            max_buckets[crt] = max(max_buckets[crt], num)
        }

        var prv = mi
        var res = 0
        for (i in 0 until l - 1) {
            if (min_buckets[i] == Int.MAX_VALUE && max_buckets[i] == Int.MIN_VALUE) {
                continue
            }
            res = max(res, min_buckets[i] - prv)
            prv = max_buckets[i]
        }
        res = max(res, ma - prv)
        return res
    }
}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun min(a: Int, b: Int): Int {
    return if (a < b) a else b
}