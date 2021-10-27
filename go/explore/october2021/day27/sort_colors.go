package main

import "fmt"

func main() {
	nums := []int{2, 0, 2, 1, 1, 0}
	sortColors(nums)
	fmt.Println(nums)
	nums = []int{2, 0, 1}
	sortColors(nums)
	fmt.Println(nums)
	nums = []int{0, 2, 2, 2, 0, 2, 1, 1}
	sortColors(nums)
	fmt.Println(nums)
}

func sortColors(nums []int) {
	n := len(nums)
	left := 0
	for left < n && nums[left] == 0 {
		left++
	}
	right := n - 1
	for right >= 0 && nums[right] == 2 {
		right--
	}
	for i := left; i <= right; i++ {
		if nums[i] == 0 {
			nums[i], nums[left] = nums[left], nums[i]
			left++
		} else if nums[i] == 2 {
			if nums[right] == 0 {
				nums[right], nums[i], nums[left] = nums[i], nums[left], nums[right]
				left++
				for right >= i && nums[right] == 2 {
					right--
				}
			} else {
				nums[i], nums[right] = nums[right], nums[i]
				for right >= i && nums[right] == 2 {
					right--
				}
			}
		}
	}
}
