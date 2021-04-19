package problem5

class Solution {
    fun longestPalindrome(s: String): String {
        val len = s.length
        var max = 1
        var ans = 0 to 1
        for (i in 0..(len - 1) * 2) {
            var l: Int
            var r: Int
            var tmp: Int
            if (i % 2 == 0) {
                l = i / 2 - 1
                r = i / 2 + 1
                tmp = 1
            } else {
                l = i / 2
                r = i / 2 + 1
                tmp = 0
            }
            while (l >= 0 && r < len && s[l] == s[r]) {
                tmp += 2
                l--
                r++
            }
            if (max < tmp) {
                max = tmp
                ans = l + 1 to r
            }
        }
        return s.substring(ans.first, ans.second)
    }
}
