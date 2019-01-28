搜索有的点node是不需要backtracking : number of islands

搜索有的path是需要backtracking的: 遍历二叉树 subsets, 

# word ladder
i

find the length of shortest transformation sequence such that:

Only one letter can be changed at a time

Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

BFS

ii

find all shortest transformation sequence(s) from beginWord to endWord, 


```
      a
  ab      ac
  abg     acd acf
          acdf acef
```
由于acdf一定会绕远路 就没必要走

从终点做bfs 算出距离  用距离使用dfs 如果能使到终点越来越近 一定是最短路径

或者起点到终点bfs 重点到起点dfs


# word pattern
i

```
Example1
Input:  pattern = "abba" and str = "dog cat cat dog"
Output: true
Explanation:
The pattern of str is abba

Example2
Input:  pattern = "abba" and str = "dog cat cat fish"
Output: false
Explanation:
The pattern of str is abbc

Example3
Input:  pattern = "aaaa" and str = "dog cat cat dog"
Output: false
Explanation:
The pattern of str is abba

Example4
Input:  pattern = "abba" and str = "dog cat cat fish"
Output: false
Explanation:
The pattern of str is abbc
```

给定一个模式串pattern和一个字符串str，请问str和pattern是否遵循相同的模式。

这里遵循模式指的是一个完全匹配，即在pattern中的每个不同的字母和str中每个非空的单词之间有一个双向映射的模式对应。

ii

没有空格了 需要自己找

那么我们可以用回溯法来生成每一种情况来判断，我们还是需要用哈希表来建立模式字符和单词之间的映射，我们还需要用变量p和r来记录当前递归到的模式字符和单词串的位置，在递归函数中，如果p和r分别等于模式字符串和单词字符串的长度，说明此时匹配成功结束了，返回ture，反之如果一个达到了而另一个没有，说明匹配失败了，返回false。如果都不满足上述条件的话，我们取出当前位置的模式字符，然后从单词串的r位置开始往后遍历，每次取出一个单词，如果模式字符已经存在哈希表中，而且对应的单词和取出的单词也相等，那么我们再次调用递归函数在下一个位置，如果返回true，那么我们就返回true。反之如果该模式字符不在哈希表中，我们要看有没有别的模式字符已经映射了当前取出的单词，如果没有的话，我们建立新的映射，并且调用递归函数，注意如果递归函数返回false了，我们要在哈希表中删去这个映射，

Given pattern = "abab", str = "redblueredblue", return true.
Given pattern = "aaaa", str = "asdasdasdasd", return true.
Given pattern = "aabb", str = "xyzabcxzyabc", return false.

# word search

i

```
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
```

ii

```
Input: 
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

Output: ["eat","oath"]
```
遍历dfs 然后查找是否在dic里存了这个
预处理前缀 使用hashmap或者 trie tree


