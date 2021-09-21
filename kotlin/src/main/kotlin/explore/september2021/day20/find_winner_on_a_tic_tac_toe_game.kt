package explore.september2021.day20

class Solution {
    companion object {
        const val N = 3
    }

    private val board = Array(N) { CharArray(N) }

    fun tictactoe(moves: Array<IntArray>): String {
        for ((i, move) in moves.withIndex()) {
            val (r, c) = move
            board[r][c] = if (i % 2 == 0) 'X' else 'O'
        }

        if (isWin('X')) {
            return "A"
        }
        if (isWin('O')) {
            return "B"
        }
        return if (moves.size == N * N) "Draw" else "Pending"
    }

    private fun isWin(mark: Char): Boolean {
        // rows
        if (board.any { row -> row.all { it == mark } })
            return true
        // cols
        if ((0 until N).any { col -> (0 until N).all { row -> board[row][col] == mark } })
            return true
        // diagonals
        if ((0 until N).all { board[it][it] == mark }) {
            return true
        }
        if ((0 until N).all { board[it][N - 1 - it] == mark }) {
            return true
        }
        return false
    }
}
