package explore.september2021.day6

class Solution {
    fun slowestKey(releaseTimes: IntArray, keysPressed: String): Char {
        var longest = releaseTimes[0]
        var res = keysPressed[0]
        for (i in 1 until releaseTimes.size) {
            val dur = releaseTimes[i] - releaseTimes[i - 1]
            if (longest < dur || (longest == dur && res < keysPressed[i])) {
                longest = dur
                res = keysPressed[i]
            }
        }
        return res
    }
}
