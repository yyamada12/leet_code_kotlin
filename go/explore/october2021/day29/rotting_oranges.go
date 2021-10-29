package main

func main() {
	println(orangesRotting(
		[][]int{
			{2, 1, 1},
			{1, 1, 0},
			{0, 1, 1},
		},
	))
	println(orangesRotting(
		[][]int{
			{2, 1, 1},
			{1, 1, 0},
			{1, 0, 1},
		},
	))
}

var dx = []int{0, 1, 0, -1}
var dy = []int{1, 0, -1, 0}

func orangesRotting(grid [][]int) int {
	m := len(grid)
	n := len(grid[0])
	dp := make([][]int, m)
	for i := 0; i < m; i++ {
		dp[i] = make([]int, n)
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			switch grid[i][j] {
			case 0:
				dp[i][j] = -1
			case 1:
				dp[i][j] = 100
			case 2:
				dp[i][j] = 0
			}
		}
	}
	for t := 0; t < n*m; t++ {
		for i := 0; i < m; i++ {
			for j := 0; j < n; j++ {
				if grid[i][j] == 1 {
					for d := 0; d < 4; d++ {
						ni := i + dx[d]
						nj := j + dy[d]
						if ni >= 0 && ni < m && nj >= 0 && nj < n && dp[ni][nj] >= 0 {
							dp[i][j] = min(dp[i][j], dp[ni][nj]+1)
						}
					}
				}
			}
		}
	}

	res := 0
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			res = max(res, dp[i][j])
		}
	}
	if res == 100 {
		return -1
	}
	return res
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
