package explore.june2021.day21

class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        var crt = listOf(1)
        res.add(crt)
        for (i in 1 until numRows) {
            val nxt = mutableListOf(1)
            for (j in 0 until crt.size - 1) {
                nxt.add(crt[j] + crt[j + 1])
            }
            nxt.add(1)
            res.add(nxt)
            crt = nxt
        }
        return res
    }
}