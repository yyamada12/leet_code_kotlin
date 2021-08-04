package main

func subsetsWithDup(nums []int) [][]int {
	m := map[int]int{}
	for _, n := range nums {
		m[n]++
	}
	res := [][]int{}
	res = append(res, []int{})
	for n, cnt := range m {
		tmp := append([][]int{}, res...)
		for i := 1; i <= cnt; i++ {
			for _, t := range tmp {
				crt := append([]int{}, t...)
				for j := 0; j < i; j++ {
					crt = append(crt, n)
				}
				res = append(res, crt)
			}
		}
	}
	return res
}
