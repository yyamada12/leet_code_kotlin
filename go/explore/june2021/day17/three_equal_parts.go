package main

import "fmt"

func main() {
	fmt.Println(threeEqualParts([]int{1, 1, 0, 0, 1, 1, 0, 1, 1, 0}))
}

func threeEqualParts(arr []int) []int {
	ones := []int{}
	for i, n := range arr {
		if n == 1 {
			ones = append(ones, i)
		}
	}
	if len(ones)%3 != 0 {
		return []int{-1, -1}
	} else if len(ones) == 0 {
		return []int{0, 2}
	}

	onesPartLen := len(ones) / 3
	for i := 1; i < onesPartLen; i++ {
		d := ones[i] - ones[i-1]
		if ones[onesPartLen+i]-ones[onesPartLen+i-1] != d {
			return []int{-1, -1}
		}
		if ones[onesPartLen*2+i]-ones[onesPartLen*2+i-1] != d {
			return []int{-1, -1}
		}
	}
	tailZeroLen := len(arr) - 1 - ones[len(ones)-1]
	if ones[onesPartLen]-ones[onesPartLen-1]-1 < tailZeroLen {
		return []int{-1, -1}
	}
	if ones[onesPartLen*2]-ones[onesPartLen*2-1]-1 < tailZeroLen {
		return []int{-1, -1}
	}
	return []int{ones[onesPartLen-1] + tailZeroLen, ones[onesPartLen*2-1] + tailZeroLen + 1}
}
