package main

import "fmt"

func main() {
	root := &Node{
		Val: 1,
		Children: []*Node{{
			Val: 3,
			Children: []*Node{
				{
					Val:      5,
					Children: []*Node{},
				},
				{
					Val:      6,
					Children: []*Node{},
				},
			},
		},
			{
				Val:      2,
				Children: []*Node{},
			},
			{
				Val:      4,
				Children: []*Node{},
			}},
	}
	fmt.Println(levelOrder(root))
}

type Node struct {
	Val      int
	Children []*Node
}

func levelOrder(root *Node) [][]int {
	if root == nil {
		return [][]int{}
	}
	crt := []*Node{root}
	nxt := []*Node{}
	res := [][]int{}
	for len(crt) > 0 {
		vals := []int{}
		for _, node := range crt {
			vals = append(vals, node.Val)
			for _, child := range node.Children {
				nxt = append(nxt, child)
			}
		}
		res = append(res, vals)
		crt = nxt
		nxt = []*Node{}
	}
	return res
}
