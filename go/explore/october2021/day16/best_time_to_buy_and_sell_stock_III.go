package main

func main() {
	println(maxProfit([]int{3, 3, 5, 0, 0, 3, 1, 4}))
	println(maxProfit([]int{1, 2, 3, 4, 5}))
	println(maxProfit([]int{7, 6, 4, 3, 1}))
	println(maxProfit([]int{1}))
}

func maxProfit(prices []int) int {
	firstBuy0, firstBuy1 := -100000, 0
	firstSell0, firstSell1 := 0, 0
	secondBuy0, secondBuy1 := -100000, 0
	secondSell0, secondSell1 := 0, 0
	for _, price := range prices {
		firstBuy1 = max(firstBuy0, -price)
		firstSell1 = max(firstSell0, firstBuy0+price)
		secondBuy1 = max(secondBuy0, firstSell0-price)
		secondSell1 = max(secondSell0, secondBuy0+price)

		firstBuy0 = firstBuy1
		firstSell0 = firstSell1
		secondBuy0 = secondBuy1
		secondSell0 = secondSell1
	}
	return max(firstSell0, secondSell0)
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
