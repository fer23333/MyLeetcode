3/19/2019
297serilize and deserilize, dfs preorder 和 bfs 的解法
ser使用dfs 和backtracking,deser 使用queue存node然后dfs
bfs相当于ser和dser两次bfs
stringbuilder 和string 在recursion中的区别  https://github.com/fer23333/MyLeetcode/blob/master/Tree/StringBuilder%E5%92%8CString%E7%9A%84%E5%8C%BA%E5%88%AB.java

3/20/2019
199. Binary Tree Right Side View,  bfs + dfs(使用depth 和 res.size() == depth 时才输出)
  
3/23
703 kth largest in data stream  using min heap
114 flatten binary tree to linkedlist
116 Populating Next Right Pointers in Each Node  完全二叉树
117.Populating Next Right Pointers in Each Node II 并非完整二叉树 可以套用 去run116  在每一次层新建dummy node 并连接 
307 Range sum query- mutable segement tree 在intial 过程建立tree 并完成 update 和sum  左子树为偶数 右子树为奇数 并保持 ij 为一左一右

3/24
921. Minimum Add to Make Parentheses Valid 栈 如果遇到'(' 推入栈, 如果遇到')' 而且栈不为空 pop, 如果为空 counter++, 最后counter加上栈的size. 
也可以使用两个变量代替栈 减少空间复杂度
22. Generate Parentheses 使用backtacking 设置 int open close max 如果open < close 就不是valid, 最后substring.length == max时 return
301. Remove Invalid Parentheses Time:使用bfs n*2^n, dfs 2^n

3.26 准备面试亚麻啦!!
简历改好了 周四面teletracking 
3.27
java基础知识 OOD
算法: 380 insert remove getRandom O(1) 使用list存 value, map存(val, index) 只删除结尾 如果需要删除的不在结尾 就换位置
381 380的followup with duplicate 如果改成map<integer,list<integer>> 找到remove数移动最后一位时,最后一位也有可能有多个数的位置 查找就不一定o(1)
  所以使用hashset存放




