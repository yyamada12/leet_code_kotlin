package explore.june2021.day22

fun main() {
    println(Solution().numMatchingSubseq("dsahjpjauf", arrayOf("ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax")))
}

class Solution {
    fun numMatchingSubseq(s: String, words: Array<String>): Int {
        val alphaIndices = mutableMapOf<Char, MutableList<Int>>()
        for (c in 'a'..'z') {
            alphaIndices[c] = mutableListOf()
        }
        for ((i, c) in s.withIndex()) {
            alphaIndices[c]!!.add(i)
        }

        var res = words.size
        for (word in words) {
            var ind = 0
            for (c in word) {
                val cIndices = alphaIndices[c]!!
                if (cIndices.size == 0) {
                    res--
                    break
                }
                val bs = cIndices.binarySearch(ind)
                if (bs >= 0) {
                    ind = cIndices[bs] + 1
                } else if (bs >= -cIndices.size) {
                    ind = cIndices[-bs - 1] + 1
                } else {
                    res--
                    break
                }
            }
        }

        return res
    }
}