package explore.september2021.day9

fun main() {
    println(Solution().orderOfLargestPlusSign(5, arrayOf(intArrayOf(4, 2))))
}

class Solution {
    fun orderOfLargestPlusSign(n: Int, mines: Array<IntArray>): Int {
        val ls = Array(n) { IntArray(n) }
        val rs = Array(n) { IntArray(n) }
        val us = Array(n) { IntArray(n) }
        val ds = Array(n) { IntArray(n) }
        val mat = Array(n) { IntArray(n) { 1 } }
        for ((x, y) in mines) {
            mat[x][y] = 0
        }
        for (i in 0 until n) {
            var cl = 0
            var cr = 0
            var cu = 0
            var cd = 0
            for (j in 0 until n) {
                if (mat[i][j] == 1) {
                    cl++
                    ls[i][j] = cl
                } else {
                    ls[i][j] = 0
                    cl = 0
                }

                if (mat[i][n - 1 - j] == 1) {
                    cr++
                    rs[i][n - 1 - j] = cr
                } else {
                    rs[i][n - 1 - j] = 0
                    cr = 0
                }

                if (mat[j][i] == 1) {
                    cu++
                    us[j][i] = cu
                } else {
                    us[j][i] = 0
                    cu = 0
                }

                if (mat[n - 1 - j][i] == 1) {
                    cd++
                    ds[n - 1 - j][i] = cd
                } else {
                    ds[n - 1 - j][i] = 0
                    cd = 0
                }
            }
        }

        var res = 0
        for (i in 0 until n) {
            for (j in 0 until n) {
                res = max(res, min(ls[i][j], rs[i][j], us[i][j], ds[i][j]))
            }
        }
        return res
    }
}

fun min(a: Int, b: Int, c: Int, d: Int): Int {
    return min(min(a, b), min(c, d))
}

fun min(a: Int, b: Int): Int {
    return if (a < b) a else b
}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}
