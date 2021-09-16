package explore.september2021.day15

class Solution {
    fun maxTurbulenceSize(arr: IntArray): Int {
        if (arr.size == 1) {
            return 1
        }
        var lastSign = arr[0] < arr[1]
        var ct = if (arr[0] == arr[1]) 1 else 2
        var res = ct
        for (i in 2 until arr.size) {
            if (arr[i - 1] == arr[i]) {
                ct = 1
            } else if (arr[i - 1] < arr[i] != lastSign) {
                ct++
            } else {
                ct = 2
            }
            res = Math.max(res, ct)
            lastSign = arr[i - 1] < arr[i]
        }
        return res
    }
}
