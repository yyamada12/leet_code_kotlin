package explore.august2021.day28

fun main() {
    println(Solution().jobScheduling(intArrayOf(1, 2, 3, 3), intArrayOf(3, 4, 5, 6), intArrayOf(50, 10, 40, 70)))
}

class Solution {
    fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
        class Job(val start: Int, val end: Int, val pro: Int)

        val jobs = startTime.indices.map {
            Job(start = startTime[it], end = endTime[it], pro = profit[it])
        }.sortedBy { job -> job.end }

        val endTimes = mutableListOf(0)
        val maxProfit = mutableMapOf<Int, Int>()

        fun latestEndTime(t: Int): Int {
            var bs = endTimes.binarySearch(t)
            if (bs < 0) {
                bs = -bs - 2
            }
            return endTimes[bs]
        }

        for (j in jobs) {
            maxProfit[j.end] = max(
                maxProfit[latestEndTime(j.end)] ?: 0,
                (maxProfit[latestEndTime(j.start)] ?: 0) + j.pro
            )
            endTimes.add(j.end)
        }
        return maxProfit[endTimes.last()] ?: 0
    }
}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}
