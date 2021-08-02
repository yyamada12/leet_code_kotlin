package main

func main() {
	println(findPeakElement([]int{1, 2, 3, 1}))
}

func findPeakElement(nums []int) int {
	l := 0
	r := len(nums) - 1
	for l < r {
		mid := (l + r) / 2
		if nums[mid] > nums[mid+1] {
			r = mid
		} else {
			l = mid + 1
		}
	}
	return l
}
