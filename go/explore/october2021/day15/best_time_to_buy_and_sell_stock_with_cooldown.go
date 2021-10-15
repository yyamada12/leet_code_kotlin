package main

func main() {
	println(maxProfit([]int{1, 2, 3, 0, 2}))
	println(maxProfit([]int{1}))
	println(maxProfit([]int{1, 2, 4}))
}

func maxProfit(prices []int) int {
	boughtPro0, boughtPro1 := -1000, 0
	coolPro0, coolPro1 := 0, 0
	soldPro0, soldPro1 := -1000, 0
	for _, price := range prices {
		coolPro1 = max(coolPro0, soldPro0)
		boughtPro1 = max(boughtPro0, coolPro0-price)
		soldPro1 = boughtPro0 + price

		boughtPro0 = boughtPro1
		coolPro0 = coolPro1
		soldPro0 = soldPro1
	}
	return max(coolPro0, soldPro0)
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
