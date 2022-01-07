package main

import (
	"fmt"
	"math/rand"
	"time"
)

func main() {
	head := &ListNode{
		1, &ListNode{
			2,
			&ListNode{
				3,
				nil,
			},
		},
	}
	s := Constructor(head)
	fmt.Println(s)
}

const N = 100

type ListNode struct {
	Val  int
	Next *ListNode
}
type Solution struct {
	head *ListNode
	crt  *ListNode
	n    int
}

func Constructor(head *ListNode) Solution {
	s := Solution{head, head, N}
	rand.Seed(time.Now().UnixNano())
	node := head
	if node == nil {
		return s
	}
	for i := 0; i < N; i++ {
		node = node.Next
		if node == nil {
			s.n = i + 1
			return s
		}
	}
	return s
}

func (this *Solution) GetRandom() int {
	if this.crt == nil {
		return 0
	}

	r := rand.Intn(this.n)
	crt := this.crt
	for i := 0; i < r; i++ {
		crt = crt.Next
		if crt == nil {
			crt = this.head
		}
	}
	this.crt = crt
	return crt.Val
}
