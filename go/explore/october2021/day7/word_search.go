package main

func main() {
	println(exist([][]byte{
		{'A', 'B', 'C', 'E'},
		{'S', 'F', 'C', 'S'},
		{'A', 'D', 'E', 'E'},
	}, "ABCCED"))
	println(exist([][]byte{
		{'A', 'B', 'C', 'E'},
		{'S', 'F', 'C', 'S'},
		{'A', 'D', 'E', 'E'},
	}, "SEE"))
	println(exist([][]byte{
		{'A', 'B', 'C', 'E'},
		{'S', 'F', 'C', 'S'},
		{'A', 'D', 'E', 'E'},
	}, "ABCB"))
	println(exist(([][]byte{
		{'a'},
	}), "a"))
}

var dr = []int{0, 1, 0, -1}
var dc = []int{1, 0, -1, 0}

var used [][]bool
var board_ [][]byte
var word_ string
var m, n int

func exist(board [][]byte, word string) bool {
	m = len(board)
	n = len(board[0])
	used = make([][]bool, m)
	for i := 0; i < m; i++ {
		used[i] = make([]bool, n)
	}
	board_ = board
	word_ = word
	for r := 0; r < m; r++ {
		for c := 0; c < n; c++ {
			if dfs(0, r, c) {
				return true
			}
		}
	}
	return false
}

func dfs(i int, r int, c int) bool {
	if i == len(word_) {
		return true
	}
	if r < 0 || r >= m || c < 0 || c >= n {
		return false
	}
	if used[r][c] || board_[r][c] != word_[i] {
		return false
	}
	used[r][c] = true
	for d := 0; d < 4; d++ {
		nr := r + dr[d]
		nc := c + dc[d]
		if dfs(i+1, nr, nc) {
			return true
		}
	}
	used[r][c] = false
	return false
}
