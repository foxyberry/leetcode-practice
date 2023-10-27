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
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        return build(inorder, 0, inorder.size - 1, postorder, 0, postorder.size - 1)
    }

    fun build(
        inorder: IntArray,
        inStart: Int,
        inEnd: Int,
        postorder: IntArray,
        postStart: Int,
        postEnd: Int
    ): TreeNode? {

        if (inStart > inEnd || postStart > postEnd) {
            return null
        }

        val rootValue = postorder[postEnd]
        val root = TreeNode(rootValue)

        var rootIndex = inStart
        while (rootIndex < inEnd) {
            if (inorder[rootIndex] == rootValue) {
                break
            }
            rootIndex++
        }

        val leftSize = rootIndex - inStart
        val rightSize = inEnd - rootIndex

        root.left = build(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + leftSize - 1)
        root.right = build(inorder, rootIndex + 1, inEnd, postorder, postEnd - rightSize, postEnd - 1)

        return root
    }

}