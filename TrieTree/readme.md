trietree 用途

1. autocomplete

2. sepll check

3. ip routng (longest prefix matching

4. word search(bingo)

时间复杂度:O(m) m为字符串长度

In each iteration of the algorithm, we either examine or create a node in the trie till we reach the end of the key. This takes only mm operations.

空间复杂度: O(m)
In the worst case newly inserted key doesn't share a prefix with the the keys already inserted in the trie. 

We have to add mm new nodes, which takes us O(m)O(m) space.

对于search操作空间都为O(1)

实现方法 
hashmap<character, trieNode>嵌套 value接着下一个children的key 

arraymap 如果全为字符串 只有26个字母
