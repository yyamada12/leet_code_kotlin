package explore.june2021.day18

class NumArray(val nums: IntArray) {
    private val bit = IntArray(nums.size + 1)

    init {
        nums.forEachIndexed { i, v -> add(i + 1, v) }
    }

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
        while (i <= nums.size) {
            bit[i] += x
            i += i and -i
        }
    }

    fun update(index: Int, `val`: Int) {
        add(index + 1, `val` - nums[index])
        nums[index] = `val`
    }

    fun sumRange(left: Int, right: Int): Int {
        return sum(right + 1) - sum(left)
    }
}