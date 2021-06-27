package explore.june2021.day26

class Solution {
    fun countSmaller(nums: IntArray): List<Int> {
        val bit = Bit(20002)
        val res = IntArray(nums.size)
        for (i in nums.size - 1 downTo 0) {
            res[i] = (bit.sum(nums[i] + 10001))
            bit.add(nums[i] + 10002, 1)
        }
        return res.toList()
    }
}

class Bit(val n: Int) {
    private val bit = IntArray(n + 1)

    fun sum(i: Int): Int {
        var res = 0
        var i = i
        while (i > 0) {
            res += bit[i]
            i -= i and -i
        }
        return res
    }

    fun add(i: Int, x: Int) {
        var i = i
        while (i <= n) {
            bit[i] += x
            i += i and -i
        }
    }
}
