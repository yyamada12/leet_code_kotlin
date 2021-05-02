package explore.may2021.day1

fun main() {
    val obj = WordFilter(
        arrayOf(
            "cabaabaaaa",
            "ccbcababac",
            "bacaabccba",
            "bcbbcbacaa",
            "abcaccbcaa",
            "accabaccaa",
            "cabcbbbcca",
            "ababccabcb",
            "caccbbcbab",
            "bccbacbcba"
        )
    )
    println(obj.f("bccbacbcba", "a"))
}

class WordFilter(words: Array<String>) {
    private val m: MutableMap<String, Int> = mutableMapOf()

    init {
        for ((i, w) in words.withIndex()) {
            for (start in w.indices) {
                val suf = w.substring(start)
                for (end in w.indices) {
                    val pre = w.substring(0, end + 1)
                    m["$suf#$pre"] = i
                }
            }
        }
    }

    fun f(prefix: String, suffix: String): Int {
        return m["$suffix#$prefix"] ?: -1
    }
}