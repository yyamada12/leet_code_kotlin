package main

import (
	"fmt"
	"math/rand"
)

func main() {
	s := Constructor([]int{1, 2, 3})
	fmt.Println(s.Shuffle())
	fmt.Println(s.Shuffle())
	fmt.Println(s.Reset())
	fmt.Println(s.Shuffle())
}

type Solution struct {
	nums []int
}

func Constructor(nums []int) Solution {
	return Solution{nums}
}

/** Resets the array to its original configuration and return it. */
func (this *Solution) Reset() []int {
	return this.nums
}

/** Returns a random shuffling of the array. */
func (this *Solution) Shuffle() []int {
	l := len(this.nums)
	nums_ := make([]int, l)
	copy(nums_, this.nums)
	for i := range nums_ {
		rnd := rand.Intn(l)
		nums_[i], nums_[rnd] = nums_[rnd], nums_[i]
	}
	return nums_
}
