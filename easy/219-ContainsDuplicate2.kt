class Solution {

    fun `containsNearbyDuplicate way1`(nums: IntArray, k: Int): Boolean {

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


    fun `containsNearbyDuplicate - shorter version`(nums: IntArray, k: Int): Boolean {

        val set = HashSet<Int>()
        for (i in 0 until nums.size) {
            if (i > k) {
                set.remove(nums[i - k - 1])
            }
            if (!set.add(nums[i])) {
                return true
            }
        }

        return false

    }

}