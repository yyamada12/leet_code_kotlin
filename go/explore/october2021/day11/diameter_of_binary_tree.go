package main

func main() {
	n1 := TreeNode{Val: 1}
	n2 := TreeNode{Val: 2}
	n3 := TreeNode{Val: 3}
	n4 := TreeNode{Val: 4}
	n5 := TreeNode{Val: 5}
	n1.Left = &n2
	n1.Right = &n3
	n2.Left = &n4
	n2.Right = &n5
	println(diameterOfBinaryTree(&n1))
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

var ans int

func diameterOfBinaryTree(root *TreeNode) int {
	ans = 0
	dfs(root)
	return ans
}

func dfs(node *TreeNode) int {
	if node == nil {
		return 0
	}
	l := dfs(node.Left)
	r := dfs(node.Right)
	ans = max(ans, l+r)
	return max(l+1, r+1)
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
