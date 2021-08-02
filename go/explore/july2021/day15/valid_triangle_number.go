package main

import "sort"

func main() {
	println(triangleNumber([]int{4, 2, 3, 4}))
}

func triangleNumber(nums []int) int {
	sort.Ints(nums)
	l := len(nums)
	res := 0
	for i := 0; i < l-2; i++ {
		for j := i + 1; j < l-1; j++ {
			res += sort.Search(l-j-1, func(k int) bool { return nums[j+k+1] >= nums[i]+nums[j] })
		}
	}
	return res
}
