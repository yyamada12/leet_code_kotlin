package explore.august2021.day30

class Solution {
    fun maxCount(m: Int, n: Int, ops: Array<IntArray>): Int {
        var mr = m
        var mc = n
        for ((r, c) in ops) {
            mr = min(mr, r)
            mc = min(mc, c)
        }
        return mr * mc
    }
}

fun min(a: Int, b: Int): Int {
    return if (a < b) a else b
}
