package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func main() {
	head := &ListNode{Val: 1}
	crt := head
	for i := 2; i <= 5; i++ {
		crt.Next = &ListNode{Val: i}
		crt = crt.Next
	}
	r := reverseKGroup(head, 3)
	for r.Next != nil {
		println(r.Val)
		r = r.Next
	}
}

func reverseKGroup(head *ListNode, k int) *ListNode {
	if k == 1 {
		return head
	}
	root := new(ListNode)
	prv := root
	crt := head
	for {
		if crt == nil || !shouldReverse(crt, k) {
			prv.Next = crt
			break
		}
		newS, nxt := reverseGroup(crt, k)
		prv.Next = newS
		crt.Next = nxt
		prv = crt
		crt = nxt
	}
	return root.Next
}

func reverseGroup(head *ListNode, k int) (newS *ListNode, nxt *ListNode) {
	prv := head
	crt := head.Next

	for i := 0; i < k-1; i++ {
		nxt = crt.Next
		crt.Next = prv
		prv = crt
		crt = nxt
	}
	return prv, nxt
}

func shouldReverse(head *ListNode, k int) bool {
	crt := head
	for i := 0; i < k-1; i++ {
		nxt := crt.Next
		if nxt == nil {
			return false
		}
		crt = nxt
	}
	return true
}
