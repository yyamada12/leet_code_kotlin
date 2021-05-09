package contest.weekly240.problem3

fun main() {
    println(Solution().maxSumMinProduct(intArrayOf(2, 3, 3, 1, 2)))
}

// wrong answer
class Solution {
    fun maxSumMinProduct(nums: IntArray): Int {
        var res = 0L
        nums.sort()
        var sum = 0L
        for (n in nums) {
            sum += n.toLong()
        }
        for (n in nums) {
            if (n * sum > res) {
                res = n * sum
            }
            sum -= n
        }
        return (res % 1000000007).toInt()
    }
}