package explore.september2021.day5

class Solution {
    fun orderlyQueue(s: String, k: Int): String {
        if (k > 1) {
            return s.toCharArray().sorted().joinToString("")
        }
        var res = s
        for (i in s.indices) {
            res = min(res, s.substring(i) + s.substring(0, i))
        }
        return res
    }
}

fun min(a: String, b: String): String {
    return if (a < b) a else b
}
