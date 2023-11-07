class Solution {
    fun missingNumber(nums: IntArray): Int {
        var sum = (nums.size * (nums.size + 1)) / 2
        for (ele in nums) {
            sum -= ele
        }
        return sum
    }
}