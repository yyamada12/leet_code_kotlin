package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func main() {
	root := TreeNode{
		0,
		&TreeNode{
			2,
			&TreeNode{4, nil, nil},
			&TreeNode{5, nil, nil},
		},
		&TreeNode{3,
			&TreeNode{6, nil, nil},
			nil,
		},
	}
	println(countNodes(&root))
}

func countNodes(root *TreeNode) int {
	leftLevel := 0
	node := root
	for node != nil {
		node = node.Left
		leftLevel++
	}
	rightLevel := 0

	node = root
	for node != nil {
		node = node.Right
		rightLevel++
	}
	if leftLevel == rightLevel {
		return (1 << leftLevel) - 1
	}

	l := 0
	r := (1 << rightLevel) - 1
	for r-l > 1 {
		m := (l + r) / 2

		node = root
		for i := rightLevel - 1; i >= 0; i-- {
			if 1&(m>>i) == 1 {
				node = node.Right
			} else {
				node = node.Left
			}
		}
		if node == nil {
			r = m
		} else {
			l = m
		}
	}
	return (1 << rightLevel) + l
}
