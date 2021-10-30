package main

func main() {
	println(longestDupSubstring("banana"))
	println(longestDupSubstring("abcd"))
}

func longestDupSubstring(s string) string {
	n := len(s)
	l := 0
	r := n
	res := ""
	for r-l > 1 {
		m := (l + r) / 2
		if ss := check(m, s); ss != "" {
			res = ss
			l = m
		} else {
			r = m
		}
	}
	return res
}

func check(length int, s string) string {
	m := map[string]bool{}
	for i := 0; i <= len(s)-length; i++ {
		if m[s[i:i+length]] {
			return s[i : i+length]
		} else {
			m[s[i:i+length]] = true
		}
	}
	return ""
}
