package main

func findDuplicates(nums []int) []int {
	res := []int{}
	bucket := make([]int, len(nums)+1)
	for _, num := range nums {
		bucket[num]++
		if bucket[num] == 2 {
			res = append(res, num)
		}
	}
	return res
}
