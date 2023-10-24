class Solution {
    fun majorityElement(nums: IntArray): List<Int> {

        var cnt1 = 0
        var cnt2 = 0

        var candidate1: Int? = null
        var candidate2: Int? = null

        for (num in nums) {
            if (candidate1 != null && candidate1 == num) {
                cnt1++
            } else if (candidate2 != null && candidate2 == num) {
                cnt2++
            } else if (cnt1 == 0) {
                candidate1 = num
                cnt1++
            } else if (cnt2 == 0) {
                candidate2 = num
                cnt2++
            } else {
                cnt1--
                cnt2--
            }
        }

        val result = ArrayList<Int>();
        val threshold = nums.size / 3

        cnt1 = 0
        cnt2 = 0
        for (num in nums) {
            if (candidate1 != null && num == candidate1) cnt1++
            if (candidate2 != null && num == candidate2) cnt2++
        }

        if (cnt1 > threshold && candidate1 != null) {
            result.add(candidate1!!)
        }
        if (cnt2 > threshold && candidate2 != null) {
            result.add(candidate2!!)
        }

        return result
    }
}