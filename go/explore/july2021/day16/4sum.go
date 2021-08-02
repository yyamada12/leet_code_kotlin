package main

import "sort"

func main() {
	for _, s := range fourSum([]int{1, 0, -1, 0, -2, 2}, 0) {
		for _, n := range s {
			print(n)
		}
		println()
	}
}

const RESET = 1000000001

func fourSum(nums []int, target int) [][]int {
	n := len(nums)
	l1 := RESET
	l2 := RESET
	l3 := RESET
	l4 := RESET

	sort.Ints(nums)
	res := [][]int{}

	for i := 0; i < n-3; i++ {
		if l1 == nums[i] {
			continue
		}
		l1 = nums[i]
		l2 = RESET
		l3 = RESET
		l4 = RESET
		for j := i + 1; j < n-2; j++ {
			if l2 == nums[j] {
				continue
			}
			l2 = nums[j]
			l3 = RESET
			l4 = RESET

			l := n - 1
			for k := j + 1; k < l; k++ {
				if l3 == nums[k] {
					continue
				}
				l3 = nums[k]
				want := target - nums[i] - nums[j] - nums[k]
				for k < l && (nums[l] > want || nums[l] == l4) {
					l4 = nums[l]
					l--
				}
				if k == l {
					break
				}
				if want == nums[l] {
					res = append(res, []int{nums[i], nums[j], nums[k], nums[l]})
				}
			}
		}
	}
	return res
}
