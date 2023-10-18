class Solution {

    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {

        val map = HashMap<Int, Int>()
        for (i in 0 until nums.size) {

            if (map[nums[i]] == null) {
                map.put(nums[i], i)
            } else {
                val target = map[nums[i]]!!
                val distance = i - target

                if (distance <= k) {
                    return true
                }

                map.put(nums[i], i)
            }
        }
        return false
    }
}