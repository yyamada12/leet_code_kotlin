package explore.may2021.day26

class Solution {
    fun minPartitions(n: String): Int {
        return n.map { it - '0' }.max()!!
    }
}