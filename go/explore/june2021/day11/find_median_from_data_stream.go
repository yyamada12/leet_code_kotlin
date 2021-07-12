package main

import (
	"container/heap"
)

// An IntHeap is a min-heap of ints.
type IntHeap []int

func (h IntHeap) Len() int           { return len(h) }
func (h IntHeap) Less(i, j int) bool { return h[i] < h[j] }
func (h IntHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *IntHeap) Push(x interface{}) {
	// Push and Pop use pointer receivers because they modify the slice's length,
	// not just its contents.
	*h = append(*h, x.(int))
}

func (h *IntHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

// This example inserts several ints into an IntHeap, checks the minimum,
// and removes them in order of priority.
func main() {
	m := Constructor()
	m.AddNum(3)
	println(m.FindMedian())
	m.AddNum(2)
	println(m.FindMedian())
	m.AddNum(9)
	println(m.FindMedian())
}

type MedianFinder struct {
	lowQ  *IntHeap
	highQ *IntHeap
}

/** initialize your data structure here. */
func Constructor() MedianFinder {
	m := MedianFinder{
		&IntHeap{},
		&IntHeap{},
	}
	heap.Init(m.lowQ)
	heap.Init(m.highQ)
	return m
}

func (this *MedianFinder) AddNum(num int) {
	heap.Push(this.highQ, num)
	heap.Push(this.lowQ, -heap.Pop(this.highQ).(int))
	if this.highQ.Len() < this.lowQ.Len() {
		heap.Push(this.highQ, -heap.Pop(this.lowQ).(int))
	}
}

func (this *MedianFinder) FindMedian() float64 {
	if this.highQ.Len() > this.lowQ.Len() {
		return float64((*this.highQ)[0])
	} else {
		return float64((*this.highQ)[0]-(*this.lowQ)[0]) / 2.0
	}
}
