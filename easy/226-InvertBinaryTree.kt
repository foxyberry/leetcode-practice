/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        val node = TreeNode(root.`val`)
        val newRight = invertTree(root.left)
        val newLeft = invertTree(root.right)
        node.right = newRight
        node.left = newLeft
        return node
    }
}