package explore.june2021.day14

fun main() {
    println(Solution().maximumUnits(arrayOf(intArrayOf(1, 3), intArrayOf(2, 2), intArrayOf(3, 1)), 4))
}

class Solution {
    fun maximumUnits(boxTypes: Array<IntArray>, truckSize: Int): Int {
        boxTypes.sortBy { -it[1] }
        var cnt = 0
        var res = 0
        for ((boxes, units) in boxTypes) {
            if (cnt + boxes <= truckSize) {
                res += boxes * units
                cnt += boxes
            } else {
                res += (truckSize - cnt) * units
                break
            }
        }
        return res
    }
}