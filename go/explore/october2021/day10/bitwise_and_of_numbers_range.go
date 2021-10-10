package main

func main() {
	println(rangeBitwiseAnd(5, 7))
	println(rangeBitwiseAnd(0, 0))
	println(rangeBitwiseAnd(1, 2147483647))
	println(rangeBitwiseAnd(4294967290, 4294967295))
	println(rangeBitwiseAnd(1, 2))
	println(rangeBitwiseAnd(3, 3))
}

func rangeBitwiseAnd(left int, right int) int {
	n := 1
	for n*2 <= right {
		n = n << 1
	}
	if n > left {
		return 0
	}
	res := left
	for n := left + 1; n <= right; n++ {
		res &= n
	}
	return res
}
