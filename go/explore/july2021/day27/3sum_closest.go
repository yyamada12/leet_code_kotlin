package main

import (
	"sort"
)

func threeSumClosest(nums []int, target int) int {
	sort.Ints(nums)
	l := len(nums)
	res := nums[0] + nums[1] + nums[2]
	for i := 0; i < l-2; i++ {
		k := l - 1
		for j := i + 1; j < l-1; j++ {
			want := target - nums[i] - nums[j]
			if abs(want-nums[k]) < abs(res-target) {
				res = nums[i] + nums[j] + nums[k]
			}
			for nums[k] > want && j < k {
				if abs(want-nums[k]) < abs(res-target) {
					res = nums[i] + nums[j] + nums[k]
				}
				k--
			}
			if j == k {
				break
			}
			if abs(want-nums[k]) < abs(res-target) {
				res = nums[i] + nums[j] + nums[k]
			}
		}
	}
	return res
}

func abs(num int) int {
	if num >= 0 {
		return num
	} else {
		return -num
	}
}
