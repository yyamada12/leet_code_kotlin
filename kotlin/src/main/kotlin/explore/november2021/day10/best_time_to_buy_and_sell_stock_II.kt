package explore.november2021.day10

fun main() {
    println(Solution().maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
}

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var res = 0
        for (i in 0 until prices.size - 1) {
            if (prices[i] < prices[i + 1]) {
                res += prices[i + 1] - prices[i]
            }
        }
        return res
    }
}
