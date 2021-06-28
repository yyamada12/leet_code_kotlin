package explore.june2021.day28

import java.util.*

class Solution {
    fun removeDuplicates(s: String): String {
        val stack = ArrayDeque<Char>()
        for (c in s) {
            if (stack.peek() == c) {
                stack.pop()
            } else {
                stack.push(c)
            }
        }
        return stack.reversed().joinToString("")
    }
}