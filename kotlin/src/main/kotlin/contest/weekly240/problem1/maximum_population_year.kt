package contest.weekly240.problem1

class Solution {
    fun maximumPopulation(logs: Array<IntArray>): Int {
        var res = 0
        var ans = 1950
        for (year in 1950..2050) {
            var c = 0
            for (log in logs) {
                if (log[0] <= year && year < log[1]) {
                    c++
                }
            }
            if (res < c) {
                res = c
                ans = year
            }
        }
        return ans
    }
}