class Solution {
    fun minMeetingRooms(intervals: Array<IntArray>): Int {

        val start = IntArray(intervals.size)
        val end = IntArray(intervals.size)

        for (i in 0 until intervals.size) {
            start[i] = intervals[i][0]
            end[i] = intervals[i][1]
        }

        start.sort()
        end.sort()

        var rooms = 0
        var endIdx = 0

        for (i in 0 until intervals.size) {
            if (start[i] < end[endIdx]) {
                rooms++
            } else {
                endIdx++
            }
        }
        return rooms
    }
}