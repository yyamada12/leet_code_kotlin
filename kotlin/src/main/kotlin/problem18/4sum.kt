package problem18

fun main() {
    println(Solution().fourSum(intArrayOf(0, 2, 2, 2, 10, -3, -9, 2, -10, -4, -9, -2, 2, 8, 7), 6))
}

class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val l = nums.size
        val twoSums = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
        for (i in 0..(l - 2)) {
            for (j in (i + 1)..(l - 1)) {
                twoSums.append(nums[i] + nums[j], i to j)
            }
        }

        val res: MutableSet<FourSums> = mutableSetOf()
        for ((key, value) in twoSums) {
            twoSums[target - key]?.let {
                for ((a, b) in value) {
                    for ((c, d) in it) {
                        if (key == -4) {
                            println("$a, $b, $c, $d")
                            println("${nums[a]}, ${nums[b]}, ${nums[c]}, ${nums[d]}")
                        }
                        if (a != c && a != d && b != c && b != d) {
                            res.add(FourSums(listOf(nums[a], nums[b], nums[c], nums[d])))
                        }
                    }
                }
            }
        }
        return res.toList().map { it.elems }
    }
}

fun MutableMap<Int, MutableList<Pair<Int, Int>>>.append(key: Int, value: Pair<Int, Int>) {
    val list = this[key] ?: mutableListOf()
    list.add(value)
    this[key] = list
}

class FourSums(val elems: List<Int>) {
    override fun equals(other: Any?): Boolean {
        if (other is FourSums) {
            return this.elems.containsAll(other.elems) && other.elems.containsAll(this.elems)
        }
        return false
    }

    override fun hashCode(): Int {
        return this.elems.map { it.hashCode() }.sum()
    }
}