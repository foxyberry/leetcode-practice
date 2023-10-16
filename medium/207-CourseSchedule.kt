class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {

        // init
        val indgree = IntArray(numCourses)
        val adj = ArrayList<ArrayList<Int>>().apply {
            for (i in 0 until numCourses) {
                add(ArrayList<Int>())
            }
        }

        for (ele in prerequisites) {
            val target = ele[0]
            val before = ele[1]
            indgree[target]++
            adj[before].add(target)
        }

        val queue = PriorityQueue<Int>()
        for (i in 0 until numCourses) {
            if (indgree[i] == 0) {
                queue.add(i)
            }
        }

        var sum = 0
        while (queue.isNotEmpty()) {

            val next = queue.poll()
            sum++

            for (ele in adj[next]) {
                indgree[ele]--
                if (indgree[ele] == 0) {
                    queue.add(ele)
                }
            }
        }

        return numCourses == sum
    }
}