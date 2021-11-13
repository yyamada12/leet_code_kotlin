package explore.november2021.day13

import java.util.*

class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val stack = ArrayDeque<Int>()
        val res = IntArray(temperatures.size)
        for ((i, temp) in temperatures.withIndex()) {
            while (!stack.isEmpty()) {
                val top = stack.peek()
                if (temperatures[top] < temp) {
                    stack.pop()
                    res[top] = i - top
                } else {
                    break
                }
            }
            stack.push(i)
        }
        return res
    }
}
