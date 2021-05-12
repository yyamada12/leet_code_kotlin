package explore.may2021.day11

class Solution {
    fun maxScore(cardPoints: IntArray, k: Int): Int {
        val n = cardPoints.size
        var sum = 0
        for (i in 0 until k) {
            sum += cardPoints[i]
        }
        var res = sum

        for (i in 0 until k) {
            sum = sum - cardPoints[k - 1 - i] + cardPoints[n - 1 - i]
            if (res < sum) {
                res = sum
            }
        }
        return res
    }
}