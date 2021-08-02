package main

var m map[int][]int

func beautifulArray(n int) []int {
	m = map[int][]int{}
	return rec(n)
}

func rec(n int) []int {
	if res, ok := m[n]; ok {
		return res
	}
	res := []int{}
	if n == 1 {
		res = []int{1}
	} else {
		odds := rec((n + 1) / 2)
		for _, odd := range odds {
			res = append(res, odd*2-1)

		}
		evens := rec(n / 2)
		for _, even := range evens {
			res = append(res, even*2)
		}
	}
	m[n] = res
	return res
}
