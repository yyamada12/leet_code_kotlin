package main

import "fmt"

func main() {
	fmt.Println(minWindow("a", "aa"))
}

func minWindow(s string, t string) string {
	if len(s) < len(t) {
		return ""
	}

	mt := map[byte]int{}
	ms := map[byte]int{}
	for i := 0; i < len(t); i++ {
		mt[t[i]]++
		ms[s[i]]++
	}

	l := 0
	r := len(t)

	if check(ms, mt) {
		return s[l:r]
	}

	min := 100001
	var ansL, ansR int

	for r < len(s) {
		for !check(ms, mt) && r < len(s) {
			println("check fail", l, ", ", r)
			ms[s[r]]++
			r++
		}

		for check(ms, mt) {
			println("check true", l, ", ", r)
			if r-l < min {
				min = r - l
				ansL = l
				ansR = r
			}

			ms[s[l]]--
			l++
		}
	}
	if min == 10001 {
		return ""
	}

	return s[ansL:ansR]

}

func check(ms map[byte]int, mt map[byte]int) bool {
	for key, val := range mt {
		if ms[key] < val {
			return false
		}
	}
	return true
}
