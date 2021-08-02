package main

func twoSum(nums []int, target int) []int {
	m := map[int]int{}
	for i, num := range nums {
		m[num] = i
	}
	for i, num := range nums {
		j, ok := m[target-num]
		if ok && j != i {
			return []int{i, j}
		}
	}
	return []int{}
}
