package main

func main() {
	println(islandPerimeter([][]int{
		{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0},
	}))
}

func islandPerimeter(grid [][]int) int {
	res := 0
	n := len(grid)
	m := len(grid[0])
	for i, row := range grid {
		for j, v := range row {
			if v == 1 {
				if i == 0 || grid[i-1][j] == 0 {
					res++
				}
				if i == n-1 || grid[i+1][j] == 0 {
					res++
				}
				if j == 0 || grid[i][j-1] == 0 {
					res++
				}
				if j == m-1 || grid[i][j+1] == 0 {
					res++
				}
			}
		}
	}
	return res
}
