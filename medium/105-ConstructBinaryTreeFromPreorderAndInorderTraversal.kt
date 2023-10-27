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
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        return build(preorder, 0, preorder.size - 1, inorder, 0, inorder.size - 1)
    }

    fun build(preorder: IntArray, preStart: Int, preEnd: Int, inorder: IntArray, inStart: Int, inEnd: Int): TreeNode? {
        if (preStart > preEnd || inStart > inEnd) {
            return null
        }
        val rootValue = preorder[preStart]
        val root = TreeNode(rootValue)
        var cur = inStart
        while (inStart < inEnd) {
            if (inorder[cur] == rootValue) {
                break
            }
            cur++
        }
        val leftSize = cur - inStart
        val rightSize = inEnd - cur
        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, cur - 1)
        root.right = build(preorder, preEnd - rightSize + 1, preEnd, inorder, cur + 1, inEnd)
        return root
    }


}