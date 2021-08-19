package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func maxProduct(root *TreeNode) int {
	m := map[*TreeNode]int{}
	s := sum(root, m)
	d := s - 1
	for _, val := range m {
		if val > s/2 {
			d = min(d, (val - (s+1)/2))
		} else {
			d = min(d, (s/2 - val))
		}
	}
	return (s/2 - d) * ((s+1)/2 + d) % 1000000007
}

func sum(node *TreeNode, m map[*TreeNode]int) int {
	if node == nil {
		return 0
	}
	res := sum(node.Left, m) + sum(node.Right, m) + node.Val
	m[node] = res
	return res
}

func min(a int, b int) int {
	if a < b {
		return a
	}
	return b
}
