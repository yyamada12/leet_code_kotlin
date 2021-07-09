package main

import "sort"

func main() {
	println(lengthOfLIS([]int{10,9,2,5,3,7,101,18}))
}

func lengthOfLIS(nums []int) int {
	l := len(nums)
	dp := make([]int, l)
	for i := 0; i < l; i++ {
		dp[i] = 10001
	}
	for _, num := range nums {
		i := sort.Search(l, func (i int) bool { return dp[i] >= num })
		println(i, num)
		dp[i] = num
	}
	return sort.Search(l, func(i int) bool {return dp[i] == 10001})
}
