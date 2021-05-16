package explore.may2021.day15

class Solution {
    fun isNumber(s: String): Boolean {
        var isAfterE = false
        var isAfterPeriod = false
        var canBeSign = true
        var isValid = false
        for (c in s) {
            when (c) {
                'e', 'E' -> {
                    if (!isValid || isAfterE) {
                        return false
                    }
                    isAfterE = true
                    canBeSign = true
                    isValid = false
                }
                '-', '+' -> {
                    if (!canBeSign) {
                        return false
                    }
                    canBeSign = false
                }
                '.' -> {
                    if (isAfterE || isAfterPeriod) {
                        return false
                    }
                    isAfterPeriod = true
                    canBeSign = false
                }
                '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' -> {
                    canBeSign = false
                    isValid = true
                }
                else -> {
                    return false
                }
            }
        }
        return isValid
    }
}