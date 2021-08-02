package main

func main() {
	println(findLength([]int{1, 2, 3, 2, 1}, []int{3, 2, 1, 4, 7}))
}

func findLength(nums1 []int, nums2 []int) int {
	n := len(nums1)
	m := len(nums2)
	dp := make([][]int, n+1)
	for i := 0; i < n+1; i++ {
		dp[i] = make([]int, m+1)
	}
	for i := 0; i < n+1; i++ {
		dp[i][m] = 0
	}
	for j := 0; j < m+1; j++ {
		dp[n][j] = 0
	}

	res := 0
	for i := n - 1; i >= 0; i-- {
		for j := m - 1; j >= 0; j-- {
			if nums1[i] == nums2[j] {
				dp[i][j] = dp[i+1][j+1] + 1
				res = max(res, dp[i][j])
			} else {
				dp[i][j] = 0
			}
		}
	}

	return res

}

func max(a int, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}
