package main

import "fmt"

func main() {
	root := &TreeNode{
		Val: 5,
		Left: &TreeNode{
			Val: 4,
			Left: &TreeNode{
				Val: 11,
				Left: &TreeNode{
					Val: 7,
				},
				Right: &TreeNode{
					Val: 2,
				},
			},
		},
		Right: &TreeNode{
			Val: 8,
			Left: &TreeNode{
				Val: 13,
			},
			Right: &TreeNode{
				Val: 4,
				Left: &TreeNode{
					Val: 5,
				},
				Right: &TreeNode{
					Val: 1,
				},
			},
		},
	}
	fmt.Println(pathSum(root, 22))
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func pathSum(root *TreeNode, targetSum int) [][]int {
	return dfs(root, []int{}, 0, targetSum)
}

func dfs(node *TreeNode, nums []int, sum int, targetSum int) [][]int {
	if node == nil {
		return [][]int{}
	}
	s := sum + node.Val
	ns := append(append([]int{}, nums...), node.Val)

	if node.Left == nil && node.Right == nil {
		if s == targetSum {
			return [][]int{ns}
		}
		return [][]int{}
	}

	res := [][]int{}
	res = append(res, dfs(node.Left, ns, s, targetSum)...)
	res = append(res, dfs(node.Right, ns, s, targetSum)...)
	return res
}
