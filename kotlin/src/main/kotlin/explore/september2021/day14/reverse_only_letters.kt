package explore.september2021.day14

class Solution {
    fun reverseOnlyLetters(s: String): String {
        val sb = StringBuilder()
        var j = s.length - 1
        for (c in s) {
            if (c in 'a'..'z' || c in 'A'..'Z') {
                while (!(s[j] in 'a'..'z' || s[j] in 'A'..'Z')) {
                    j--
                }
                sb.append(s[j])
                j--
            } else {
                sb.append(c)
            }
        }
        return sb.toString()
    }
}
