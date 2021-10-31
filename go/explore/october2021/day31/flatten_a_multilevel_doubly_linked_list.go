package main

type Node struct {
	Val   int
	Prev  *Node
	Next  *Node
	Child *Node
}

func flatten(root *Node) *Node {
	recFlatten(root)
	return root
}

func recFlatten(root *Node) *Node {
	crt := root
	for crt != nil {
		nxt := crt.Next
		child := crt.Child
		if child != nil {
			crt.Next = child
			child.Prev = crt
			crt.Child = nil
			lastChild := recFlatten(child)
			if nxt != nil {
				nxt.Prev = lastChild
				lastChild.Next = nxt
			} else {
				return lastChild
			}
		}
		if nxt == nil {
			return crt
		}
		crt = nxt
	}
	return crt
}
