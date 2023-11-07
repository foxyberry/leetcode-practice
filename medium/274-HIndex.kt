class Solution {
    fun hIndex(citations: IntArray): Int {

        val count = IntArray(citations.size + 1)
        val len = citations.size
        for (citation in citations) {
            if (citation > len) {
                count[len]++
            } else {
                count[citation]++
            }
        }

        var total = 0
        for (i in len downTo 0) {
            total += count[i]
            if (total >= i) {
                return i
            }
        }
        return 0
    }
}