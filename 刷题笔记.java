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
linkedlistcycle, mergek
382 LinkedList random node 先量出长度 再随便取几步. 如果长度很长 使用Reservoir Sampling 水塘采样, 确保每次抽数是在这些数范围内其中一个 即为随机抽样了 
for(int i=1;c.next != null;i++){c = c.next;   if(random.nextInt(i + 1) == i) r = c.val; } return r;
也可以为(random.nextInt(i + 1) == 1)
528 Random pick with weight [1 2 3 4] presum变为[1 3 6 10]就可变为概率 注意二分left<right if nums[mid]<ndex, left=mid+1 exclusive刚才的点,最后return left/right 都对
4.4
bq
4.5
BQ
3 Longest Substring Without Repeating Characters 注意left指针要为 map.get(right)+1 和left的最大值 不然abba-> 第二个a时left就变小了
4.6
211 Add and Search Word - Data structure design 使用TrieTree 注意 search包含"." 使用backtracking
208 trietree
ood 
4.7
212 word search II 使用 trie tree
986. Interval List Intersections sol1:没有交集的情况 A.start > B.end a++, B.end > A.start, b++. else 有交集 result.add 然后如果 A.end <B.end, a++
sol2> 直接考虑有交集 是在 low = max(a.start, b.start) high = min(a.end, b.end)的情况, 然后考虑a.end < b.end 所以不用考虑没交集情况 
56merge interval 设定result.add(intervals.get(0)); 每次取出result最后一位作为cur 比较cur.end >= interval.start, 取大的end 作为新的cur.end
meeting room
meeting room ii sort start, PQ end  如果堆不为空，且首元素小于等于当前区间的起始时间，我们去掉堆中的首元素，
把当前区间的结束时间压入堆，由于最小堆是小的在前面，那么假如首元素小于等于起始时间，说明上一个会议已经结束，可以用该会议室开始下一个会议了
解法二: sort start数组和end 数组 如果当前起始时间小于结束时间指针的时间，则结果自增1，反之结束时间指针自增1，这样我们可以找出重叠的时间段
314 Binary Tree vertical order 本质就是bfs,一个queue存node, 一个queue存 col, 一个map存col->list of node, 记录一下min max值 再顺着加入result
4.8
面完indeed 学完ood最后两节课 
merge k sorted list 先把全部头节点加入最小堆. 然后定义dummy node  dummy.next = queue.poll(), dummy = dummy.next 这样会指到list上的node, 然后如果dummy.next不会空 再加入堆
spiral matrix 设定top down left right 设置边界条件 然后走一圈



