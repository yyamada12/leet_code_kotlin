package main

func findJudge(n int, trust [][]int) int {
	if n == 1 {
		return 1
	}
	m := map[int]int{}
	for _, t := range trust {
		m[t[0]]--
		m[t[1]]++
	}
	for k, v := range m {
		if v == n-1 {
			return k
		}
	}
	return -1
}
