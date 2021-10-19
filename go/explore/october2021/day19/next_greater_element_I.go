package main

import "fmt"

func main() {
	fmt.Println(nextGreaterElement(
		[]int{4, 1, 2},
		[]int{1, 3, 4, 2},
	))
	fmt.Println(nextGreaterElement(
		[]int{2, 4},
		[]int{1, 2, 3, 4},
	))
}

func nextGreaterElement(nums1 []int, nums2 []int) []int {
	m := map[int]int{}
	l2 := len(nums2)
	s := NewStack()
	for i := l2 - 1; i >= 0; i-- {
		n := nums2[i]
		for !s.Empty() && n > s.Peek() {
			s.Pop()
		}
		if s.Empty() {
			m[n] = -1
			s.Push(n)
		} else {
			m[n] = s.Peek()
			s.Push(n)
		}
	}
	res := make([]int, len(nums1))
	for i, n := range nums1 {
		res[i] = m[n]
	}
	return res
}

type Stack []int

// Push adds an element
func (s *Stack) Push(v int) {
	*s = append(*s, v)
}

// Pop removes the top element and return it
func (s *Stack) Pop() int {
	if s.Empty() {
		return 0
	}

	v := (*s)[len(*s)-1]
	*s = (*s)[:len(*s)-1]
	return v
}

// Peek returns the top value
func (s *Stack) Peek() int {
	if s.Empty() {
		return 0
	}

	return (*s)[len(*s)-1]
}

// Empty returns true when stack is empty
func (s *Stack) Empty() bool {
	return len(*s) == 0
}

// NewStack generates stack
func NewStack() *Stack {
	s := new(Stack)
	return s
}
