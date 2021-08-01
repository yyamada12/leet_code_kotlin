package main

func trap(height []int) int {
	l := len(height)
	if l == 0 {
		return 0
	}
	lm := make([]int, l)
	lm[0] = height[0]
	for i := 1; i < l; i++ {
		lm[i] = max(lm[i-1], height[i])
	}
	rm := make([]int, l)
	rm[l-1] = height[l-1]
	for i := l - 2; i >= 0; i-- {
		rm[i] = max(rm[i+1], height[i])
	}

	res := 0
	for i := 0; i < l; i++ {
		res += min(lm[i], rm[i]) - height[i]
	}
	return res
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
