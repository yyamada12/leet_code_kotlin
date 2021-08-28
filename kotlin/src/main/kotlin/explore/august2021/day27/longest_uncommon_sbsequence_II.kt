package explore.august2021.day27

class Solution {
    fun findLUSlength(strs: Array<String>): Int {
        val m = mutableMapOf<String, Int>()
        for (str in strs) {
            for (i in 1 until (1 shl str.length)) {
                var s = ""
                for (j in str.indices) {
                    if ((i shr j) and 1 == 1) {
                        s += str[j]
                    }
                }
                m[s] = (m[s] ?: 0) + 1
            }
        }
        var res = -1
        for ((k, v) in m) {
            if (v == 1) {
                res = max(res, k.length)
            }
        }
        return res
    }
}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}
