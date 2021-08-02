package main

func largestIsland(grid [][]int) int {
	n := len(grid)

	ans := -1
	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == 0 {
				ans = max(ans, count(grid, i, j))
			}
		}
	}
	if ans == -1 {
		return n * n
	}
	return ans
}

func count(grid [][]int, r int, c int) int {
	dx := []int{0, 1, 0, -1}
	dy := []int{1, 0, -1, 0}

	n := len(grid)
	q := []int{r*n + c}
	seen := map[int]bool{}

	for len(q) > 0 {
		crt := q[0]
		x := crt / n
		y := crt % n
		q = q[1:]
		seen[crt] = true

		for k := 0; k < 4; k++ {
			nx := x + dx[k]
			ny := y + dy[k]
			if nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 1 && !seen[nx*n+ny] {
				q = append(q, nx*n+ny)
			}
		}
	}
	return len(seen)
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
