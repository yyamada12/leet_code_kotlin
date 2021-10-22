package main

import (
	"sort"
	"strings"
)

func main() {
	println(frequencySort("tree"))
}

func frequencySort(s string) string {
	m := map[rune]int{}
	for _, c := range s {
		m[c] = m[c] + 1
	}
	pairs := []Pair{}
	for key, val := range m {
		pairs = append(pairs, Pair{key, val})
	}
	sort.Sort(sort.Reverse(PairList(pairs)))

	sb := strings.Builder{}
	for _, p := range pairs {
		for i := 0; i < p.val; i++ {
			sb.WriteRune(p.key)
		}
	}
	return sb.String()
}

type Pair struct {
	key rune
	val int
}

type PairList []Pair

func (p PairList) Len() int           { return len(p) }
func (p PairList) Less(i, j int) bool { return p[i].val < p[j].val }
func (p PairList) Swap(i, j int)      { p[i], p[j] = p[j], p[i] }
