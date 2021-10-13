package main

import "fmt"

func main() {
	fmt.Println(bstFromPreorder([]int{1}))
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func bstFromPreorder(preorder []int) *TreeNode {
	root := TreeNode{Val: preorder[0]}
	for _, v := range preorder[1:] {
		add(&root, v)
	}
	return &root
}

func add(root *TreeNode, v int) {
	n := root
	for {
		if v < n.Val {
			if n.Left == nil {
				n.Left = &TreeNode{Val: v}
				return
			}
			n = n.Left
		} else {
			if n.Right == nil {
				n.Right = &TreeNode{Val: v}
				return
			}
			n = n.Right
		}
	}
}
