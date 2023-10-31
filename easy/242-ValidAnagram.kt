class Solution {
    fun isAnagram(s: String, t: String): Boolean {

        if (s.length != t.length) {
            return false
        }

        val check = IntArray(26) { 0 }

        for (c in s) {
            check[c - 'a']++
        }

        for (c in t) {
            check[c - 'a']--
        }

        for (c in check) {
            if (c != 0) {
                return false
            }
        }
        return true
    }

    fun isAnagramWay2(s: String, t: String): Boolean {

        if (s.length != t.length) {
            return false
        }

        val s1 = s.toCharArray()
        val t1 = t.toCharArray()

        s1.sort() // O(nlogn)
        t1.sort() // O(nlogn)

        for (i in 0 until s.length) {
            if (s1[i] != t1[i]) {
                return false
            }
        }

        return true
    }


}