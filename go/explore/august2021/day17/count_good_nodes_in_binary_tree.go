package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func goodNodes(root *TreeNode) int {
	return dfs(-100001, root)
}

func dfs(max int, node *TreeNode) int {
	if node == nil {
		return 0
	}
	v := node.Val
	if max <= v {
		return dfs(v, node.Left) + dfs(v, node.Right) + 1
	}
	return dfs(max, node.Left) + dfs(max, node.Right)
}
