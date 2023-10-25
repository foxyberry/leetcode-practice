/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun isPalindrome(head: ListNode?): Boolean {

        var cur = head
        val stack = Stack<Int>()
        while(cur!=null){
            stack.push(cur.`val`)
            cur = cur.next
        }

        cur = head
        while(cur!=null){
            if(cur.`val` != stack.pop()){
                return false
            }
            cur = cur.next
        }
        return true
    }
}