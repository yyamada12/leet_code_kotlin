package main

func main() {
	println(calculateMinimumHP([][]int{
		{0},
	}))
}

func calculateMinimumHP(dungeon [][]int) int {
	l := 0
	r := 400000
	for r-l > 1 {
		m := (l + r) / 2
		if canRescue(m, dungeon) {
			r = m
		} else {
			l = m
		}
	}
	return r
}

func canRescue(hp int, dungeon [][]int) bool {
	if dungeon[0][0]+hp <= 0 {
		return false
	}
	n := len(dungeon)
	m := len(dungeon[0])
	dp := make([][]int, n)
	for i := 0; i < n; i++ {
		dp[i] = make([]int, m)
	}
	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			dp[i][j] = -1
		}
	}
	dp[0][0] = hp + dungeon[0][0]
	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			if i > 0 && dp[i-1][j] > 0 {
				dp[i][j] = max(dp[i][j], dp[i-1][j]+dungeon[i][j])
			}
			if j > 0 && dp[i][j-1] > 0 {
				dp[i][j] = max(dp[i][j], dp[i][j-1]+dungeon[i][j])
			}
		}
	}
	return dp[n-1][m-1] > 0
}

func max(a int, b int) int {
	if a > b {
		return a
	}
	return b
}
