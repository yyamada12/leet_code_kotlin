package main

func main() {
	println(numSquares(12))
}

func numSquares(n int) int {
	dp := make([]int, n+1)
	for i := 1; i < n+1; i++ {
		dp[i] = 10001
	}
	for s := 1; s*s <= n; s++ {
		sq := s * s
		for i := sq; i < n+1; i++ {
			dp[i] = min(dp[i], dp[i-sq]+1)
		}
	}
	return dp[n]
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
