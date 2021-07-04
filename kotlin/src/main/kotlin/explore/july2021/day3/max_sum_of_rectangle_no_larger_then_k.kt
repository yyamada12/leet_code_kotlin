package explore.july2021.day3

fun main() {
    println(Solution().maxSumSubmatrix(arrayOf(intArrayOf(2, 2, -1)), 3))
}

class Solution {
    fun maxSumSubmatrix(matrix: Array<IntArray>, k: Int): Int {
        val m = matrix.size
        val n = matrix[0].size
        val sums = Array(m) { IntArray(n) }
        var res = Int.MIN_VALUE
        for (i in 0 until m) {
            for (j in 0 until n) {
                sums[i][j] = matrix[i][j]
                if (i > 0) {
                    sums[i][j] += sums[i - 1][j]
                }
                if (j > 0) {
                    sums[i][j] += sums[i][j - 1]
                }
                if (i > 0 && j > 0) {
                    sums[i][j] -= sums[i - 1][j - 1]
                }
                for (x in 0..i) {
                    for (y in 0..j) {
                        var sum = sums[i][j]
                        if (x > 0) {
                            sum -= sums[x - 1][j]
                        }
                        if (y > 0) {
                            sum -= sums[i][y - 1]
                        }
                        if (x > 0 && y > 0) {
                            sum += sums[x - 1][y - 1]
                        }
                        if (sum <= k) {
                            res = max(res, sum)
                        }
                    }
                }

            }
        }
        return res
    }
}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}