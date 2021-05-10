package explore.may2021.day10

class Solution {
    fun countPrimes(n: Int): Int {
        if (n < 2) {
            return 0
        }
        var res = 0
        val isPrime = BooleanArray(n)
        for (i in 2 until n) {
            isPrime[i] = true
        }
        for (i in 2 until n) {
            if (isPrime[i]) {
                res++
                for (j in (i * 2) until n step i) {
                    isPrime[j] = false
                }
            }
        }
        return res
    }
}