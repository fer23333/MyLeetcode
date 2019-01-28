# word ladder
BFS

ii

find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time

Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

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
