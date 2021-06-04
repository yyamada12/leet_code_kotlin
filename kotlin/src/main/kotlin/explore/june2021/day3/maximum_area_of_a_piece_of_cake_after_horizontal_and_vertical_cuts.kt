package explore.june2021.day3

class Solution {
    fun maxArea(h: Int, w: Int, horizontalCuts: IntArray, verticalCuts: IntArray): Int {
        horizontalCuts.sort()
        verticalCuts.sort()
        var maxh = 0
        var prv = 0
        for (cut in horizontalCuts) {
            maxh = max(maxh, cut - prv)
            prv = cut
        }
        maxh = max(maxh, h - prv)
        var maxv = 0
        prv = 0
        for (cut in verticalCuts) {
            maxv = max(maxv, cut - prv)
            prv = cut
        }
        maxv = max(maxv, w - prv)
        return (maxh.toLong() * maxv % 1000000007).toInt()

    }
}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}