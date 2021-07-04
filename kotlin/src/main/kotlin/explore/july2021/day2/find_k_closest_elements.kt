package explore.july2021.day2

import java.util.*

fun main() {
    println(Solution().findClosestElements(intArrayOf(1, 1, 1, 10, 10, 10), 1, 9))
}

class Solution {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        val bs = arr.binarySearch(x)
        var r = if (bs < 0) -bs - 1 else bs
        var l = r - 1
        val res = ArrayDeque<Int>()
        for (i in 0 until k) {
            if (l < 0) {
                res.add(arr[r])
                r++
                continue
            }
            if (r >= arr.size) {
                res.push(arr[l])
                l--
                continue
            }
            if (arr[r] - x < x - arr[l]) {
                res.add(arr[r])
                r++
            } else {
                res.push(arr[l])
                l--
            }
        }
        return res.toList()
    }
}