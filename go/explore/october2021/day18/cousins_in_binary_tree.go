package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func isCousins(root *TreeNode, x int, y int) bool {
	nodes := []*TreeNode{}
	if root != nil {
		nodes = append(nodes, root)
	}
	for len(nodes) > 0 {
		l := len(nodes)
		found := false
		for i := 0; i < l; i++ {
			n := nodes[i]
			if n.Val == x || n.Val == y {
				if found {
					return true
				} else {
					found = true
				}
			}

			if n.Right != nil && n.Left != nil && ((n.Right.Val == x && n.Left.Val == y) || (n.Right.Val == y && n.Left.Val == x)) {
				return false
			}

			if n.Right != nil {
				nodes = append(nodes, n.Right)
			}
			if n.Left != nil {
				nodes = append(nodes, n.Left)
			}
		}
		if found {
			return false
		}
		nodes = nodes[l:]
	}
	return false
}
