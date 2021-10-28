package main

import (
	"fmt"
	"sort"
)

func main() {
	fmt.Println(threeSum([]int{-1, 0, 1, 2, -1, -4}))
}

func threeSum(nums []int) [][]int {
	n := len(nums)
	sort.Ints(nums)

	res := [][]int{}
	for i := 0; i < n-2; i++ {
		if i > 0 && nums[i-1] == nums[i] {
			continue
		}
		r := n - 1
		for l := i + 1; l < r; l++ {
			if l > i+1 && nums[l-1] == nums[l] {
				continue
			}
			for l+1 < r && nums[i]+nums[l]+nums[r] > 0 {
				r--
			}
			if nums[i]+nums[l]+nums[r] == 0 {
				res = append(res, []int{nums[i], nums[l], nums[r]})
			}
		}
	}
	return res
}
