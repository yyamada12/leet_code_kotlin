package problem10

fun main() {
    println(Solution().isMatch("a", "ab*"))
}

class Solution {
    fun isMatch(s: String, p: String): Boolean {
        val sl = s.length
        val pl = p.length
        var i = 0
        while (i < pl) {
            when (p[i]) {
                '.' -> {
                    if (i + 1 < pl && p[i + 1] == '*') {
                        if (i >= sl) {
                            return isMatch("", p.substring(i + 2))
                        }
                        for (n in 0..(sl - i)) {
                            if (isMatch(s.substring(i + n), p.substring(i + 2)))
                                return true
                        }
                        return false
                    } else {
                        if (i >= sl) {
                            return false
                        }
                        i++
                    }
                }
                else -> {
                    if (i + 1 < pl && p[i + 1] == '*') {
                        if (i >= sl) {
                            return isMatch("", p.substring(i + 2))
                        }
                        for (n in 0..(sl - i)) {
                            if (n > 0 && s[i + n - 1] != p[i]) {
                                break
                            }
                            if (isMatch(s.substring(i + n), p.substring(i + 2)))
                                return true
                        }
                        return false
                    } else {
                        if (i >= sl || s[i] != p[i]) {
                            return false
                        }
                        i++
                    }
                }
            }
        }
        return sl == pl
    }
}