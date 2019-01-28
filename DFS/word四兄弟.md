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
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.(i.e if a corresponds to s, then b cannot correspond to s. For example, given pattern = "ab", str = "ss", return false.)

Given pattern = "abab", str = "redblueredblue", return true.
Given pattern = "aaaa", str = "asdasdasdasd", return true.
Given pattern = "aabb", str = "xyzabcxzyabc", return false.
