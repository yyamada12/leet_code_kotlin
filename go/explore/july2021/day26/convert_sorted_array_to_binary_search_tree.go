package main

func main() {
	t := sortedArrayToBST([]int{1, 2})
	println(t.Val, t.Left.Val)
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func sortedArrayToBST(nums []int) *TreeNode {
	l := len(nums)
	if l == 1 {
		return &TreeNode{Val: nums[0]}
	}
	if l == 2 {
		return &TreeNode{nums[l/2], sortedArrayToBST(nums[:l/2]), nil}
	}

	return &TreeNode{nums[l/2], sortedArrayToBST(nums[:l/2]), sortedArrayToBST(nums[l/2+1:])}
}
