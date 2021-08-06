package main

var memo map[int]map[int]int

func stoneGame(piles []int) bool {
	l := len(piles)
	memo = map[int]map[int]int{}
	for i := 0; i < l-1; i++ {
		memo[i] = map[int]int{}
	}
	return dfs(0, len(piles)-1, piles) > 0
}

func dfs(l, r int, piles []int) int {
	if l == r {
		return 0
	}
	if res, ok := memo[l][r]; ok {
		return res
	}
	res := max(piles[l]-dfs(l+1, r, piles), piles[r]-dfs(l, r-1, piles))
	memo[l][r] = res
	return res
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
