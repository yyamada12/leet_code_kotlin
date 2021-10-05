package main

func main() {
	println(climbStairs(1))
	println(climbStairs(2))
	println(climbStairs(3))
}

func climbStairs(n int) int {
	prv := 0
	crt := 1
	for i := 0; i < n; i++ {
		prv, crt = crt, prv+crt
	}
	return crt
}
