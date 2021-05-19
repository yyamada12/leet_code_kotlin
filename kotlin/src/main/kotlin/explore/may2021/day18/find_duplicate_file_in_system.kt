package explore.may2021.day18

fun main() {
    println(
        Solution().findDuplicate(
            arrayOf(
                "root/a 1.txt(abcd) 2.txt(efgh)",
                "root/c 3.txt(abcd)",
                "root/c/d 4.txt(efgh)",
                "root 4.txt(efgh)"
            )
        )
    )
}

class Solution {
    fun findDuplicate(paths: Array<String>): List<List<String>> {
        val m = mutableMapOf<String, MutableList<String>>()
        for (path in paths) {
            val (dir, files) = path.split(' ', limit = 2)
            for (file in files.split(' ')) {
                val (filename, content) = file.split('(')
                m.append(content.trimEnd(')'), "$dir/$filename")
            }
        }
        return m.filter { it.value.size >= 2 }.values.toList()
    }
}

fun MutableMap<String, MutableList<String>>.append(key: String, value: String) {
    val l = this[key] ?: mutableListOf()
    l.add(value)
    this[key] = l
}