package main

type NumArray struct {
	sums []int
}

func Constructor(nums []int) NumArray {
	s := 0
	sums := []int{}
	for _, num := range nums {
		s += num
		sums = append(sums, s)
	}
	return NumArray{sums}
}

func (this *NumArray) SumRange(left int, right int) int {
	if left == 0 {
		return this.sums[right]
	}
	return this.sums[right] - this.sums[left-1]
}
