package explore.may2021.day23

class Solution {
    fun shortestSuperstring(words: Array<String>): String {
        val combs = mutableMapOf<String, Map<String, String>>()
        for (w1 in words) {
            val m = mutableMapOf<String, String>()
            for (w2 in words) {
                if (w1 == w2) {
                    continue
                }
                m[w2] = superstring(w1, w2)
            }
            combs[w1] = m
        }
        val m = mutableMapOf<String, String>()
        for (word in words) {
            m[word] = word
        }
        combs[""] = words.associate { it to it }

        val memo = (words + "").associate {
            it to mutableMapOf<List<String>, String>()
        }


        fun dfs(remain: List<String>, before: String): String {
            if (memo[before]!!.containsKey(remain)) {
                return memo[before]!![remain]!!
            }
            val res = remain.map {
                val r = remain.toMutableList()
                r.remove(it)
                combs[before]!![it] + dfs(r, it)
            }.minBy { it.length } ?: ""
            memo[before]!![remain] = res
            return res
        }
        return dfs(words.toList(), "")
    }
}

fun superstring(s1: String, s2: String): String {
    for (i in 1 until s1.length) {
        if (s2.startsWith(s1.substring(i))) {
            return s2.substring(s1.length - i)
        }
    }
    return s2
}