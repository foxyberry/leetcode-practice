class Solution {
    
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {

        val indgree = IntArray(numCourses) { 0 }
        val map = HashMap<Int, ArrayList<Int>>().apply {
            for (i in 0 until numCourses) {
                this.put(i, ArrayList<Int>())
            }
        }

        for (course in prerequisites) {
            val t1 = course[0]
            val t2 = course[1]
            indgree[t1]++
            map[t2]!!.add(t1)
        }

        val queue = LinkedList<Int>()
        for (i in 0 until numCourses) {
            if (indgree[i] == 0) {
                queue.add(i)
            }
        }

        var sum = 0
        val result = ArrayList<Int>()
        while (queue.isNotEmpty()) {

            val target = queue.poll()
            result.add(target)
            sum++
            for (ele in map[target]!!) {
                indgree[ele]--
                if (indgree[ele] == 0) {
                    queue.add(ele)
                }
            }
        }

        return if (sum == numCourses) result.toIntArray() else IntArray(0)
    }


}