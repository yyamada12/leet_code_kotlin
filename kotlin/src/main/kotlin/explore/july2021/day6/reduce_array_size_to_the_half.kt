package explore.july2021.day6

class Solution {
    fun minSetSize(arr: IntArray): Int {
        val m = mutableMapOf<Int, Int>()
        for (n in arr) {
            m[n] = (m[n] ?: 0) + 1
        }
        val target = (arr.size + 1) / 2
        var crt = 0
        var res = 0
        for (cnt in m.values.sortedDescending()) {
            crt += cnt
            res++
            if (crt >= target) {
                break
            }
        }
        return res
    }
}