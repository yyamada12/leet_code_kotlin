package explore.august2021.day22

fun main() {
    println(
        Solution().rectangleArea(
            arrayOf(
                intArrayOf(0, 0, 1000000000, 1000000000)
            )
        )
    )
}

class Solution {
    fun rectangleArea(rectangles: Array<IntArray>): Int {
        val xset = mutableSetOf<Int>()
        val yset = mutableSetOf<Int>()
        for (rec in rectangles) {
            xset.add(rec[0])
            yset.add(rec[1])
            xset.add(rec[2])
            yset.add(rec[3])
        }
        val xs = xset.toList().sorted()
        val ys = yset.toList().sorted()

        val mat = Array(xs.size) { BooleanArray(ys.size) }
        for (rec in rectangles) {
            val x0 = xs.binarySearch(rec[0])
            val y0 = ys.binarySearch(rec[1])
            val x1 = xs.binarySearch(rec[2])
            val y1 = ys.binarySearch(rec[3])

            for (i in x0 until x1) {
                for (j in y0 until y1) {
                    mat[i][j] = true
                }
            }
        }

        var res = 0
        val M = 1000000007
        for (x in xs.indices) {
            for (y in ys.indices) {
                if (mat[x][y]) {
                    res = (res + (xs[x + 1] - xs[x]).toLong() * (ys[y + 1] - ys[y]) % M).toInt() % M
                }
            }
        }
        return res
    }
}