package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func pathSum(root *TreeNode, targetSum int) int {
	return dfs(root, targetSum, []int{})
}

func dfs(node *TreeNode, targetSum int, sums []int) int {
	if node == nil {
		return 0
	}
	res := 0
	sums_ := make([]int, len(sums)+1)
	for i, sum := range sums {
		sums_[i] = sum + node.Val
		if sums_[i] == targetSum {
			res++
		}
	}
	sums_[len(sums)] = node.Val
	if node.Val == targetSum {
		res++
	}
	return res + dfs(node.Left, targetSum, sums_) + dfs(node.Right, targetSum, sums_)
}
