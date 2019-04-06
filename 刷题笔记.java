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
  
3.28
tletracking 面完了 发了oa coding+html/javascript+database 工资 7w5+ bounus =8W 现在发展 cloud java anugalr react
amazon 
680 valid palidrome ii 删除一个 判定是否是palidrome,双指针 先到不同的位置 再跳过一个left or right 看isvalid

3.29
31 next permutation 三步: 1.从j=n-2开始 遇到递减停下(等于时继续), 若j=-1 则为54321 2. 找到j之前恰好大于他的数i(由于是递减的) 3 swap j和i 再对后面部分排序
98 validate BST  递归: 左子树 负无穷到a,右子树a到正无穷 intger记录max min 初始化为null 然后递归
非递归: inorder 记录上一次prev节点 prev初始化为null cur = stack.pop之后 判定prev不为null且值不小于cur return false
94 inorder taversal 非递归解法

3.30
ood 入门 elevator system
339. Nested List Weight Sum 和level order 类似 先把第一层的integer 加上 不是integer 就将一层的list加入queue, level++.
144preorder 非递归解法 只有res.add地方不一样 其他地方一样
230. Kth Smallest Element in a BST 也可以用inorder 非递归解决 --k== 0, return; 
规律是都在res.add的那个地方操作

3.31
修改bq 
ood第二节课 desing parking lot

4.1
继承 抽象类 接口的区别
67addbinary 和 addnumbers, addintegers, merge two sorted array/list 类似 使用sum每次初始化为carry, sum完后 result加入sum%2 carry = sum/2, 最后要加入可能的进位, 然后reverse 
66 plus one 有一个tricky逻辑 如果数小于9 就+1 提前返回, 如果不是就变为0. 若能走完循环就新建array length+1;
2 add two numbers 类似逻辑 创建dummy,head 然后 循环中新建cur cur+=carry 后判定l1,l2 carry cur.val操作后 链表往后移 最后判定是否加1
445 add two numbersii 正向链表. 使用stack,建立一个node 每次赋给sum%10 每次建立一个carry node 值为sum/10. 再让carry指向node. 最后判定node是否为0
注意int a = s.charAt(i) - '0' 等价于 int a = Character.getNumericValue(s.charAt(i));

4.2
20 valid parentheses 使用stack else if(stack.isEmpty() || stack.pop() != c) return false; 如果栈为空 说明没有先放入左括号. 如果不相等 说明可能中间有别的括号. 最后判定栈空了没有
EG: ([)] false, {[]()} true } false

4.3
linkedlist  19removen 一定要有dummy node 要注意 [1,2] n=2 和 [1] n=1 的特殊情况
,linkedlistcycle, mergek

4.4
bq
4.5
BQ
