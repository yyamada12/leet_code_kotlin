package explore.may2021.day21

class Solution {
    fun findAndReplacePattern(words: Array<String>, pattern: String): List<String> {
        return words.filter { word ->
            val m = mutableMapOf<Char, Char>()
            val s = mutableSetOf<Char>()
            for ((i, w) in word.withIndex()) {
                val p = pattern[i]
                if (m.containsKey(w)) {
                    if (m[w] != p) {
                        return@filter false
                    }
                } else {
                    if (s.contains(p)) {
                        return@filter false
                    }
                    s.add(p)
                    m[w] = p
                }
            }
            return@filter true
        }
    }
}