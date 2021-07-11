package main

import "fmt"

func main() {
	fmt.Println(numDecodings("2839"))
}

const M = 1000000007

func numDecodings(s string) int {
	n := len(s)
	dp := make([]int, n+1)
	dp[n] = 1

	switch s[n-1] {
	case '*':
		dp[n-1] = 9
	case '0':
		dp[n-1] = 0
	default:
		dp[n-1] = 1
	}

	for i := n - 2; i >= 0; i-- {
		switch s[i] {
		case '*':
			switch {
			case s[i+1] == '*':
				//11~19, 21~26
				dp[i] = (9*dp[i+1]%M + 15*dp[i+2]%M) % M
			case '0' <= s[i+1] && s[i+1] <= '6':
				dp[i] = (9*dp[i+1]%M + 2*dp[i+2]%M) % M
			default:
				dp[i] = (9*dp[i+1]%M + dp[i+2]) % M
			}
		case '0':
			dp[i] = 0
		case '1':
			switch {
			case s[i+1] == '*':
				dp[i] = (dp[i+1] + 9*dp[i+2]%M) % M
			default:
				dp[i] = (dp[i+1] + dp[i+2]) % M
			}
		case '2':
			switch {
			case s[i+1] == '*':
				dp[i] = (dp[i+1] + 6*dp[i+2]%M) % M
			case '0' <= s[i+1] && s[i+1] <= '6':
				dp[i] = (dp[i+1] + dp[i+2]) % M
			default:
				dp[i] = dp[i+1]
			}
		default:
			dp[i] = dp[i+1]
		}
	}
	return dp[0]
}
