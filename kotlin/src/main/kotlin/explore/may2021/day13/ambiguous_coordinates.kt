package explore.may2021.day13

class Solution {
    fun ambiguousCoordinates(s: String): List<String> {
        val res = mutableListOf<String>()
        val target = s.substring(1, s.length - 1)
        for (i in 1 until target.length) {
            val fsts = addPeriods(target.substring(0, i))
            val scds = addPeriods(target.substring(i))

            for (fst in fsts) {
                for (scd in scds) {
                    res.add("($fst, $scd)")
                }
            }
        }
        return res
    }
}

fun addPeriods(s: String): List<String> {
    val res = mutableListOf<String>()
    if (s.length == 1) {
        return listOf(s)
    }
    if (s.startsWith('0')) {
        return if (s.endsWith('0')) {
            emptyList()
        } else {
            listOf("0." + s.substring(1))
        }
    }
    if (s.endsWith('0')) {
        return listOf(s)
    }

    res.add(s)
    for (i in 1 until s.length) {
        res.add(s.substring(0, i) + "." + s.substring(i))
    }
    return res
}