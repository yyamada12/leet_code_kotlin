package problems.problem3

fun main() {
    println(Solution().lengthOfLongestSubstring("abcabcbb"))
}

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val l = mutableSetOf<Char>()
        var start = 0
        var end = 0
        var res = 0
        while (end < s.length) {
            val c = s[end]
            if (l.contains(c)) {
                res = max(res, end - start)
                var f = true
                while (f) {
                    if (s[start] == c) {
                        f = false
                    }
                    l.remove(s[start])
                    start++
                }
            }
            l.add(c)
            end++
        }
        res = max(res, end - start)
        return res
    }
}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}