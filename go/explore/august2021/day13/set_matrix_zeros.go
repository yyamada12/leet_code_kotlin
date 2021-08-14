package main

func setZeroes(matrix [][]int) {
	r0 := false
	for i, row := range matrix {
		for j, val := range row {
			if val == 0 {
				if i == 0 {
					r0 = true
				} else {
					matrix[i][0] = 0
				}
				matrix[0][j] = 0
			}
		}
	}
	for i := 1; i < len(matrix); i++ {
		if matrix[i][0] == 0 {
			for j := range matrix[0] {
				matrix[i][j] = 0
			}
		}
	}
	for j := range matrix[0] {
		if matrix[0][j] == 0 {
			for i := range matrix {
				matrix[i][j] = 0
			}
		}
	}
	if r0 {
		for j := range matrix[0] {
			matrix[0][j] = 0
		}
	}
	return
}
