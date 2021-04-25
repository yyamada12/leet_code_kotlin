package problem14

class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        var i = 0;
        var res = "";
        while (true) {
            val c = strs[0][i]
            for (str in strs) {
                if (i >= str.length || str[i] != c) {
                    return res
                }
            }
            res += c
            i++
        }
    }
}