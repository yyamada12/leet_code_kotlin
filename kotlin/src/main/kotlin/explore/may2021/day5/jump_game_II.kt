package explore.may2021.day5

class Solution {
    fun jump(nums: IntArray): Int {
        val l = nums.size
        nums[l - 1] = 0
        var crt: Int
        for (i in l - 2 downTo 0) {
            crt = nums[i]
            nums[i] = 1000
            for (j in 1..crt) {
                val dst = i + j
                if (dst >= l) {
                    break
                }
                nums[i] = min(nums[i], nums[dst] + 1)
            }
        }
        return nums[0]
    }
}

fun min(a: Int, b: Int): Int {
    return if (a < b) a else b
}