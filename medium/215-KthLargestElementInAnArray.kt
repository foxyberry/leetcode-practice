class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {

        val queue = PriorityQueue<Int>{a, b -> b - a}
        for(ele in nums){
           queue.add(ele)
        }

        for(i in 1 until k){
            queue.poll()
        }

        return queue.poll()
    }
}