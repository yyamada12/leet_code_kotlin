package explore.september2021.day16

fun main() {
    println(
        Solution().spiralOrder(
            arrayOf(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(5, 6, 7, 8),
                intArrayOf(9, 10, 11, 12)
            )
        )
    )
}

class Solution {
    enum class STATUS {
        RIGHT, DOWN, LEFT, UP
    }

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        var l = 0
        var r = matrix[0].size - 1
        var u = 0
        var d = matrix.size - 1

        var i = 0
        var j = 0
        val res = mutableListOf(matrix[0][0])
        var st = when {
            (r == 0 && d == 0) -> return res
            r == 0 -> STATUS.DOWN
            else -> STATUS.RIGHT
        }
        while (true) {
            when (st) {
                STATUS.RIGHT -> {
                    j++
                    res.add(matrix[i][j])
                    if (j == r) {
                        if (i == d) {
                            return res
                        } else {
                            st = STATUS.DOWN
                            u++
                        }
                    }
                }
                STATUS.DOWN -> {
                    i++
                    res.add(matrix[i][j])
                    if (i == d) {
                        if (j == l) {
                            return res
                        } else {
                            st = STATUS.LEFT
                            r--
                        }
                    }
                }
                STATUS.LEFT -> {
                    j--
                    res.add(matrix[i][j])
                    if (j == l) {
                        if (i == u) {
                            return res
                        } else {
                            st = STATUS.UP
                            d--
                        }
                    }
                }
                STATUS.UP -> {
                    i--
                    res.add(matrix[i][j])
                    if (i == u) {
                        if (j == r) {
                            return res
                        } else {
                            st = STATUS.RIGHT
                            l++
                        }
                    }
                }
            }
        }
    }
}
