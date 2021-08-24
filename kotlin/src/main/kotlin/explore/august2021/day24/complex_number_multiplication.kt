package explore.august2021.day24

class Solution {
    fun complexNumberMultiply(num1: String, num2: String): String {
        val (r1, i1) = num1.trimEnd('i').split("+").map { it.toInt() }
        val (r2, i2) = num2.trimEnd('i').split("+").map { it.toInt() }
        return "${r1 * r2 - i1 * i2}+${r1 * i2 + r2 * i1}i"
    }
}