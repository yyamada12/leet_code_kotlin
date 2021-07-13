package main

func main() {
	println(isIsomorphic("badc", "baba"))
}

func isIsomorphic(s string, t string) bool {
	m1 := map[byte]byte{}
	m2 := map[byte]byte{}
	for i, c := range []byte(s) {
		rep, ok := m1[c]
		if ok {
			if rep != t[i] {
				return false
			}
		} else {
			_, ok := m2[t[i]]
			if ok {
				return false
			}
			m1[c] = t[i]
			m2[t[i]] = c
		}
	}
	return true
}
