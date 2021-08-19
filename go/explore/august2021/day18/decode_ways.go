package main

func main() {
	println(numDecodings("12"))
	println(numDecodings("226"))
	println(numDecodings("0"))
	println(numDecodings("06"))
	println(numDecodings("10"))
}

func numDecodings(s string) int {
	if s[0] == '0' {
		return 0
	}
	l := len(s)
	if l == 1 {
		return 1
	}
	dp := make([]int, l+1)
	dp[0] = 1
	dp[1] = 1

	for i := 1; i < l; i++ {
		switch s[i] {
		case '0':
			if s[i-1] == '1' || s[i-1] == '2' {
				dp[i+1] = dp[i-1]
			} else {
				return 0
			}
		case '1', '2', '3', '4', '5', '6':
			if s[i-1] == '1' || s[i-1] == '2' {
				dp[i+1] = dp[i-1] + dp[i]
			} else {
				dp[i+1] = dp[i]
			}
		default:
			if s[i-1] == '1' {
				dp[i+1] = dp[i-1] + dp[i]
			} else {
				dp[i+1] = dp[i]
			}
		}

	}

	return dp[l]
}
