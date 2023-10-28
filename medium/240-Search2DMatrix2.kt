class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {

        var col = matrix[0].size - 1
        var row = 0

        while (col >= 0 && row <= matrix.size - 1) {
            if (target == matrix[row][col]) {
                return true
            } else if (target < matrix[row][col]) {
                col--
            } else {
                row++
            }
        }
        return false
    }
}