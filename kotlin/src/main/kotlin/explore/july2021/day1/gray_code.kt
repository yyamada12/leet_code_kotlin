package explore.july2021.day1

class Solution {
    fun grayCode(n: Int): List<Int> {
        val res = mutableListOf(0)
        for (i in 0 until n) {
            for (e in res.reversed()) {
                res.add(e + (1 shl i))
            }
        }
        return res
    }
}