package explore.july2021.day5

class Solution {
    fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        val n = mat.size
        val m = mat[0].size
        if (m * n != r * c) {
            return mat
        }
        val res = Array(r) { IntArray(c) }
        for (i in 0 until r) {
            for (j in 0 until c) {
                val x = i * c + j
                res[i][j] = mat[x / m][x % m]
            }
        }
        return res
    }
}