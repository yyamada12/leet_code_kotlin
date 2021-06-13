package explore.june2021.day13

fun main() {
    val s = Solution()
    println(s.palindromePairs(arrayOf("abcd", "dcba", "lls", "s", "sssll")))
    println(s.palindromePairs(arrayOf("a", "")))
}

class Solution {
    fun palindromePairs(words: Array<String>): List<List<Int>> {
        val m = words.mapIndexed { i, v -> v to i }.toMap()
        val res = mutableListOf<List<Int>>()
        for ((i, w) in words.withIndex()) {
            var rev = ""
            val l = w.length
            for (j in w.indices) {
                if (isPalindrome(w.substring(0, l - j))) {
                    m[rev]?.let { res.add(listOf(it, i)) }
                }
                rev += w[l - 1 - j]
            }
            if (rev != w) {
                m[rev]?.let {
                    res.add(listOf(it, i))
                }
            }
            for (j in l - 1 downTo 0) {
                rev = rev.substring(1)
                if (isPalindrome(w.substring(j, l))) {
                    m[rev]?.let {
                        res.add(listOf(i, it))
                    }
                }
            }
        }
        return res
    }
}

fun isPalindrome(s: String): Boolean {
    val l = s.length
    for (i in 0..l / 2) {
        if (s[i] != s[l - i - 1]) {
            return false
        }
    }
    return true
}