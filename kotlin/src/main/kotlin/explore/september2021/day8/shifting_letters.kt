package explore.september2021.day8

class Solution {
    fun shiftingLetters(s: String, shifts: IntArray): String {
        val c = s.toCharArray()
        var sum = 0
        for (i in shifts.size - 1 downTo 0) {
            sum = (sum + shifts[i]) % 26
            c[i] = 'a' + ((c[i] - 'a') + sum) % 26
        }
        return c.joinToString("")
    }
}
