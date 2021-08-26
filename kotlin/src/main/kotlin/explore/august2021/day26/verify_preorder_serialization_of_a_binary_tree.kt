package explore.august2021.day26


class Solution {
    fun isValidSerialization(preorder: String): Boolean {
        val inputs = preorder.split(',')
        var ct = 1
        for (node in inputs) {
            if (ct == 0) {
                return false
            }
            if (node == "#") {
                ct--
            } else {
                ct++
            }
        }
        return ct == 0
    }
}
