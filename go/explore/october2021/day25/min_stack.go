package main

func main() {
	obj := Constructor()
	obj.Push(-2)
	obj.Push(0)
	obj.Push(-3)
	println(obj.GetMin())
	obj.Pop()
	println(obj.Top())
	println(obj.GetMin())
}

type MinStack struct {
	s []int
	m []int
}

func Constructor() MinStack {
	return MinStack{[]int{}, []int{}}
}

func (this *MinStack) Push(val int) {
	this.s = append(this.s, val)
	m := this.m
	if len(m) == 0 {
		this.m = append(m, val)
	} else {
		this.m = append(m, min(val, m[len(m)-1]))
	}
}

func (this *MinStack) Pop() {
	this.s = this.s[:len(this.s)-1]
	this.m = this.m[:len(this.m)-1]
}

func (this *MinStack) Top() int {
	return this.s[len(this.s)-1]
}

func (this *MinStack) GetMin() int {
	return this.m[len(this.m)-1]
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
