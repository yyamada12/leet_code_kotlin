package main

import (
	"sort"
)

func main() {
	println(kthSmallest([][]int{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8))
	println(kthSmallest([][]int{{1000000000}}, 1))
}

func kthSmallest(matrix [][]int, k int) int {
	l := -1000000000
	r := 1000000001
	for r-l > 1 {
		x := (l + r) / 2
		if count(x, matrix) < k {
			l = x
		} else {
			r = x
		}
	}
	return l
}

func count(x int, mat [][]int) int {
	res := 0
	for _, row := range mat {
		i := sort.Search(len(row), func(i int) bool { return row[i] >= x })
		res += i
	}
	return res
}
