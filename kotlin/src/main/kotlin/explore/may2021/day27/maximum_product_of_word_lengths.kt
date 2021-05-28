package explore.may2021.day27

class Solution {
    fun maxProduct(words: Array<String>): Int {
        val m = words.map { it to it.toCharArray().toSet() }.toMap()

        val l = words.size
        var res = 0
        for (i in 0 until l - 1) {
            loop@ for (j in i + 1 until l) {
                for (c in m[words[i]]!!) {
                    if (m[words[j]]!!.contains(c)) {
                        continue@loop
                    }
                }
                res = max(res, words[i].length * words[j].length)
            }
        }
        return res
    }
}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}