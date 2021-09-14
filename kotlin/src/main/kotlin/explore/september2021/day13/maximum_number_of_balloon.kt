package explore.september2021.day13

class Solution {
    fun maxNumberOfBalloons(text: String): Int {
        val cnt = IntArray(26)
        for (c in text) {
            cnt[c - 'a']++
        }
        return listOf(cnt['b' - 'a'], cnt['a' - 'a'], cnt['l' - 'a'] / 2, cnt['o' - 'a'] / 2, cnt['n' - 'a']).min()!!
    }
}
