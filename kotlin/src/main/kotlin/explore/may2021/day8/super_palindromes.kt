package explore.may2021.day8

fun main() {
    println(Solution().superpalindromesInRange("1", "2"))
}

class Solution {
    fun superpalindromesInRange(left: String, right: String): Int {
        return (1..100000)
            .flatMap {
                val s = it.toString()
                listOf(
                    (s + s.subSequence(0, s.length - 1).reversed()).toLong(),
                    (s + s.reversed()).toLong()
                )
            }
            .map { it * it }
            .filter { isPalindromes(it.toString()) }
            .filter { left.toLong() <= it && it <= right.toLong() }
            .size
    }

    fun isPalindromes(str: String): Boolean {
        val l = str.length
        for (i in 0 until l / 2) {
            if (str[i] != str[l - 1 - i]) {
                return false
            }
        }
        return true
    }
}