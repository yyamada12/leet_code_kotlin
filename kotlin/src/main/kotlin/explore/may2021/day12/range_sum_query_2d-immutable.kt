package explore.may2021.day12

fun main() {
    println(
        NumMatrix(
            arrayOf(
                intArrayOf(3, 0, 1, 4, 2),
                intArrayOf(5, 6, 3, 2, 1),
                intArrayOf(1, 2, 0, 1, 5),
                intArrayOf(4, 1, 0, 1, 7),
                intArrayOf(1, 0, 3, 0, 5)
            )
        ).sumRegion(2, 1, 4, 3)
    )
}

class NumMatrix(matrix: Array<IntArray>) {
    private val sum: Array<IntArray>

    init {
        val m = matrix.size
        val n = matrix[0].size
        sum = matrix
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (i > 0) {
                    sum[i][j] += sum[i - 1][j]
                }
                if (j > 0) {
                    sum[i][j] += sum[i][j - 1]
                }
                if (i > 0 && j > 0) {
                    sum[i][j] -= sum[i - 1][j - 1]
                }
            }
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        var res = sum[row2][col2]
        if (row1 > 0) {
            res -= sum[row1 - 1][col2]
        }
        if (col1 > 0) {
            res -= sum[row2][col1 - 1]
        }
        if (row1 > 0 && col1 > 0) {
            res += sum[row1 - 1][col1 - 1]
        }
        return res
    }

}