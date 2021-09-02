package explore.september2021.day1


class Solution {
    val seen = mutableSetOf<Int>()
    fun arrayNesting(nums: IntArray): Int {
        var res = 0
        for (num in nums) {
            if (!seen.contains(num)) {
                res = max(res, dfs(num, nums[num], 1, nums))
            }
        }
        return res
    }

    fun dfs(s: Int, i: Int, ct: Int, nums: IntArray): Int {
        seen.add(i)
        if (s == i) return ct
        return dfs(s, nums[i], ct + 1, nums)
    }
}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}
