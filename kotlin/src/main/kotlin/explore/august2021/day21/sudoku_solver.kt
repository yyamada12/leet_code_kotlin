package explore.august2021.day21

fun main() {
    println('1' - '0')
}

class Solution {
    fun solveSudoku(board: Array<CharArray>): Unit {
        dfs(board, 0)
    }

    fun dfs(board: Array<CharArray>, i: Int): Boolean {
        if (i == 81) {
            return true
        }
        val r = i / 9
        val c = i % 9

        if (board[r][c] != '.') {
            return dfs(board, i + 1)
        }

        val rr = r / 3 * 3
        val cc = c / 3 * 3
        val possibles = mutableSetOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        for (row in board) {
            if (row[c] != '.') {
                possibles.remove(row[c] - '0')
            }
        }
        for (i in 0 until 9) {
            if (board[r][i] != '.') {
                possibles.remove(board[r][i] - '0')
            }
        }
        for (i in rr until rr + 3) {
            for (j in cc until cc + 3) {
                if (board[i][j] != '.') {
                    possibles.remove(board[i][j] - '0')
                }
            }
        }
        for (n in possibles) {
            board[r][c] = '0' + n
            if (dfs(board, i + 1)) {
                return true
            }
        }
        board[r][c] = '.'
        return false
    }
}