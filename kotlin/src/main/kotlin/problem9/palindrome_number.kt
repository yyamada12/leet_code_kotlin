package problem9

class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) {
            return false
        }
        var tmp = x
        var y = 0
        while (tmp > 0) {
            y = y * 10 + tmp % 10
            tmp /= 10
        }
        return x == y
    }
}