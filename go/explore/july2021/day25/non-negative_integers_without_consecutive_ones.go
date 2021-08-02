package main

func main() {
	println(findIntegers(1))
	println(findIntegers(2))
	println(findIntegers(3))
	println(findIntegers(4))
	println(findIntegers(5))
	println(findIntegers(6))
	println(findIntegers(7))
	println(findIntegers(8))
	println(findIntegers(9))
	println(findIntegers(10))
	println(findIntegers(11))
	println(findIntegers(12))
	println(findIntegers(13))
	println(findIntegers(14))
	println(findIntegers(15))
}

func findIntegers(n int) int {
	fib := []int{1, 2}
	i := 2
	for ; 1<<i <= n+1; i++ {
		fib = append(fib, fib[i-2]+fib[i-1])
	}

	res := 0
	prv := 0
	for ; i >= 0; i-- {
		if (1<<i)&n != 0 {
			res += fib[i]
			if prv == 1 {
				res--
				break
			}
			prv = 1
		} else {
			prv = 0
		}
	}

	return res + 1
}
