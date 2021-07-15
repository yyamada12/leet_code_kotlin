package main

import "strings"

func main() {
	println(customSortString("cba", "abcd"))
}

func customSortString(order string, str string) string {
	m := map[rune]int{}
	sb := strings.Builder{}
	for _, c := range str {
		if strings.Contains(order, string(c)) {
			m[c]++
		} else {
			sb.WriteRune(c)
		}
	}
	for _, c := range order {
		for i := 0; i < m[c]; i++ {
			sb.WriteRune(c)
		}
	}
	return sb.String()
}
