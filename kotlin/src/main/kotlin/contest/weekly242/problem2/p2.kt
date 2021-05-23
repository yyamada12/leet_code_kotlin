package contest.weekly242.problem2

import kotlin.math.ceil

class Solution {
    fun minSpeedOnTime(dist: IntArray, hour: Double): Int {
        if ((dist.size - 1).toDouble() >= hour) {
            return -1
        }
        var mi = 0;
        var ma = 10000000
        fun judge(s: Int): Boolean {
            var sum = 0.0
            for ((i, d) in dist.withIndex()) {
                if (i == dist.size - 1) {
                    sum += d.toDouble() / s
                } else {
                    sum += ceil(d.toDouble() / s)
                }
            }
            return hour >= sum
        }
        while (ma - 1 > mi) {
            val crt = (ma + mi) / 2
            if (judge(crt)) {
                ma = crt
            } else {
                mi = crt
            }
        }
        return ma
    }
}