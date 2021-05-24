package explore.may2021.day24

class Solution {
    fun toLowerCase(s: String): String {
        return s.map { c -> if (c in 'A'..'Z') c - ('A' - 'a') else c }.joinToString("")
    }
}