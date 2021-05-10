package explore.may2021.day9

import java.util.*

fun main() {
    println(Solution().isPossible(intArrayOf(9, 3, 5)))
}

class Solution {
    fun isPossible(target: IntArray): Boolean {
        if (target.size == 1) {
            return target[0] == 1
        }
        val desc: Comparator<Int> = compareBy { -it }
        val pq = PriorityQueue(desc)
        var sum = 0L
        for (t in target) {
            sum += t
            pq.add(t)
        }

        while (sum > target.size) {
            val top = pq.poll()
            sum -= top
            if (sum == 1L) {
                return true
            }
            if (sum >= top || top % sum == 0L) {
                return false
            }
            val nxt = top % sum
            sum += nxt
            pq.add(nxt.toInt())
        }
        return true
    }
}