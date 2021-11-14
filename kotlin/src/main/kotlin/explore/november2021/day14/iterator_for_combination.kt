package explore.november2021.day14

fun main() {
    val c = CombinationIterator("abc", 2)
    println(c.next())
    println(c.hasNext())
    println(c.next())
    println(c.hasNext())
    println(c.next())
    println(c.hasNext())
}

class CombinationIterator(val characters: String, val combinationLength: Int) {
    val indices = IntArray(16)
    var isInited = false

    fun next(): String {
        if (!isInited) {
            for (i in 0 until combinationLength) {
                indices[i] = i
            }
            indices[combinationLength] = characters.length
            isInited = true
        } else {
            for (i in combinationLength - 1 downTo 0) {
                if (indices[i] != indices[i + 1] - 1) {
                    indices[i]++
                    for (j in i + 1 until combinationLength) {
                        indices[j] = indices[j - 1] + 1
                    }
                    break
                }
            }
        }
        return (0 until combinationLength).map { characters[indices[it]] }.joinToString("")
    }

    fun hasNext(): Boolean {
        for (i in combinationLength - 1 downTo 0) {
            if (indices[i] != indices[i + 1] - 1) {
                return true
            }
        }
        return false
    }

}
