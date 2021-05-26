package explore.may2021.day25

class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val s = ArrayDeque<Int>()
        for (token in tokens) {
            when (token) {
                "+" -> {
                    val fst = s.removeFirst()
                    val scd = s.removeFirst()
                    s.addFirst(fst + scd)
                }
                "-" -> {
                    val fst = s.removeFirst()
                    val scd = s.removeFirst()
                    s.addFirst(scd - fst)
                }
                "*" -> {
                    val fst = s.removeFirst()
                    val scd = s.removeFirst()
                    s.addFirst(fst * scd)
                }
                "/" -> {
                    val fst = s.removeFirst()
                    val scd = s.removeFirst()
                    s.addFirst(scd / fst)
                }
                else -> {
                    s.addFirst(token.toInt())
                }
            }
        }
        return s.first()
    }
}