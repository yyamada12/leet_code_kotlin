package explore.june2021.day10

class MyCalendar() {

    val m = sortedMapOf<Int, Int>()

    fun book(start: Int, end: Int): Boolean {
        if (m.isEmpty()) {
            m[start] = end
            return true
        }
        val keys = m.keys.toList()
        val s = keys.binarySearch(start)
        if (s >= 0) {
            return false
        }
        val afterStart = -s - 1
        if (afterStart < keys.size && keys[afterStart] < end) {
            return false
        }
        val beforeStart = -s - 2
        if (beforeStart >= 0 && m[keys[beforeStart]]!! > start) {
            return false
        }
        m[start] = end
        return true
    }
}