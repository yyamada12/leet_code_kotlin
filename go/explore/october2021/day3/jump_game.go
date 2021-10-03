package main

func main() {
	println(canJump([]int{2, 3, 1, 1, 4}))
	println(canJump([]int{3, 2, 1, 0, 4}))
}

func canJump(nums []int) bool {
	n := len(nums)
	i := 0
	leachable := 0
	for i <= leachable && i < n {
		leachable = max(leachable, i+nums[i])
		i++
	}
	return i == n
}

func max(a int, b int) int {
	if a > b {
		return a
	}
	return b
}
