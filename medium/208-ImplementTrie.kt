class Trie() {
    
    class TrieNode {
        val children = Array<TrieNode?>(26) { null }
        var isWord = false
    }

    val root = TrieNode()

    fun insert(word: String) {
        var node = root
        for (c in word) {
            val index = c - 'a'
            if (node.children[index] == null) {
                node.children[index] = TrieNode()
            }
            node = node.children[index]!!
        }
        node.isWord = true
    }

    fun search(word: String): Boolean {
        var node = root
        for (c in word) {
            var index = c - 'a'
            if (node.children[index] == null) {
                return false
            }
            node = node.children[index]!!
        }
        return node.isWord
    }

    fun startsWith(prefix: String): Boolean {
        var node = root
        for (c in prefix) {
            val index = c - 'a'
            if (node.children[index] == null) {
                return false
            }
            node = node.children[index]!!
        }
        return true
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */