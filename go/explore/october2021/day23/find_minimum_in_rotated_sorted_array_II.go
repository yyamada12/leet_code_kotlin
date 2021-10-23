package main

func main() {
	println(findMin([]int{1, 3, 5}))
	println(findMin([]int{2, 2, 2, 0, 1}))
	println(findMin([]int{4, 5, 6, 7, 0, 1, 4}))
	println(findMin([]int{10, 1, 10, 10, 10}))
}

func findMin(nums []int) int {
	n := len(nums)
	if n == 1 {
		return nums[0]
	}
	l := 0
	r := n - 1
	if nums[l] < nums[r] {
		return nums[0]
	}
	for r-l > 1 {
		m := (l + r) / 2
		if nums[m] > nums[l] {
			l = m
		} else if nums[m] < nums[l] {
			r = m
		} else {
			if nums[m] > nums[r] {
				l = m
			} else {
				return min(findMin(nums[l+1:m]), findMin(nums[m:r-1]))
			}
		}
	}
	return nums[r]
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
