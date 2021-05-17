package explore.may2021.day17

fun main() {
    val arr = arrayOf("a", "b", "ba", "bca", "bda", "bdca")
    println(Solution().longestStrChain(arr))
}

class Solution {
    fun longestStrChain(words: Array<String>): Int {
        words.sortBy { it.length }
        var res = 1
        val m = mutableMapOf<String, Int>()
        for (word in words) {
            var chain = 1
            for (i in word.indices) {
                m[word.substring(0, i) + word.substring(i + 1)]?.let {
                    if (chain < it + 1) {
                        chain = it + 1
                    }
                }
            }
            m[word] = chain
            if (res < chain) {
                res = chain
            }
        }
        return res
    }
}