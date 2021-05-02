package explore.may2021.day1

fun main() {
    println(WordFilter(arrayOf("apple")).f("a", "e"))
}

class WordFilter(words: Array<String>) {
    private val trie = TrieNode()

    init {
        for (i in words.indices) {
            val word = words[i] + "{"
            for (start in word.indices) {
                var cur = trie
                cur.index = i
                for (j in start until 2 * word.length - 1) {
                    val k = word[j % word.length] - 'a'
                    if (cur.children[k] == null) {
                        cur.children[k] = TrieNode()
                    }
                    cur = cur.children[k]!!
                    cur.index = i
                }
            }
        }
    }

    fun f(prefix: String, suffix: String): Int {
        println(trie)
        var cur = trie
        for (c in "$suffix{$prefix") {
            cur = cur.children[c - 'a'] ?: return -1
        }
        return cur.index
    }
}

class TrieNode {
    val children: Array<TrieNode?> = arrayOfNulls(27)
    var index = -1
}