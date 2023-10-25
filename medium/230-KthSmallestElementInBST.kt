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
class Solution1 {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val array = ArrayList<Int>()
        inorder(root, array)
        return array.get(k - 1)
    }

    fun inorder(root: TreeNode?, list: ArrayList<Int>) {
        if (root == null) {
            return
        }
        inorder(root.left, list)
        list.add(root.`val`)
        inorder(root.right, list)
    }
}

class Solution2 {

    var cnt = 0
    var result = -1

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        traverse(root, k)
        return result
    }

    fun traverse(root: TreeNode?, k: Int) {
        if (root == null) {
            return
        }

        traverse(root.left, k)
        cnt++
        if (cnt == k) {
            result = root.`val`
            return
        }
        traverse(root.right, k)
    }
}