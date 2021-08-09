package main

func addStrings(num1 string, num2 string) string {
	l1 := len(num1)
	l2 := len(num2)
	var r1 []rune
	var r2 []rune
	if l1 > l2 {
		r1 = []rune(num1)
		r2 = []rune(num2)
	} else {
		r1 = []rune(num2)
		r2 = []rune(num1)
	}

	j := len(r2) - 1
	c := 0
	res := make([]rune, len(r1))
	for i := len(r1) - 1; i >= 0; i-- {
		n1 := int(r1[i] - '0')

		n2 := 0
		if j >= 0 {
			n2 = int(r2[j] - '0')
		}
		j--

		s := n1 + n2 + c
		c = s / 10
		res[i] = rune('0' + (s % 10))
	}
	if c == 1 {
		return "1" + string(res)
	}
	return string(res)
}
