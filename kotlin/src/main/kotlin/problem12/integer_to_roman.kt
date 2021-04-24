package problem12

fun main() {
    println(Solution().intToRoman(234))
}

class Solution {
    fun intToRoman(num: Int): String {
        val res1 = when (num % 10) {
            1 -> "I"
            2 -> "II"
            3 -> "III"
            4 -> "IV"
            5 -> "V"
            6 -> "VI"
            7 -> "VII"
            8 -> "VIII"
            9 -> "IX"
            else -> ""
        }
        val res2 = when (num / 10 % 10) {
            1 -> "X"
            2 -> "XX"
            3 -> "XXX"
            4 -> "XL"
            5 -> "L"
            6 -> "LX"
            7 -> "LXX"
            8 -> "LXXX"
            9 -> "XC"
            else -> ""
        }
        val res3 = when (num / 100 % 10) {
            1 -> "C"
            2 -> "CC"
            3 -> "CCC"
            4 -> "CD"
            5 -> "D"
            6 -> "DC"
            7 -> "DCC"
            8 -> "DCCC"
            9 -> "CM"
            else -> ""
        }
        val res4 = when (num / 1000) {
            1 -> "M"
            2 -> "MM"
            3 -> "MMM"
            else -> ""
        }

        return res4 + res3 + res2 + res1
    }
}