package main

import "sort"

type Pair struct {
	km int
	n  int
}

type Pairs []Pair

func (s Pairs) Len() int {
	return len(s)
}

func (s Pairs) Swap(i, j int) {
	s[i], s[j] = s[j], s[i]
}

func (s Pairs) Less(i, j int) bool {
	return s[i].km < s[j].km
}

func carPooling(trips [][]int, capacity int) bool {
	pairs := Pairs{}
	for _, trip := range trips {
		pairs = append(pairs, Pair{trip[1]*2 + 1, trip[0]}, Pair{trip[2] * 2, -trip[0]})
	}
	sort.Sort(pairs)

	passengers := 0
	for _, pair := range pairs {
		passengers += pair.n
		if passengers > capacity {
			return false
		}
	}
	return true
}
