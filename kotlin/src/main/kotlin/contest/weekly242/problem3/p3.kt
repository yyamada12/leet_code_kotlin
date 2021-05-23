package contest.weekly242.problem3

// TLE
class Solution {
    fun canReach(s: String, minJump: Int, maxJump: Int): Boolean {
        val dp = IntArray(s.length)
        val seen = mutableSetOf<Int>()
        for ((i, c) in s.withIndex()) {
            if (c == '1') {
                dp[i] = -1
                seen.add(i)
            }
        }
        fun dfs(crt: Int) {
            if (seen.contains(crt)) {
                return
            }
            seen.add(crt)
            dp[crt] = 1
            for (step in minJump..maxJump) {
                if (crt + step >= s.length) {
                    break
                }
                dfs(crt + step)
            }
        }
        dfs(0)
        return dp[s.length - 1] == 1
    }
}
