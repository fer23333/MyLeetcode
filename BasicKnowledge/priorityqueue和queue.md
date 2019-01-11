http://www.cnblogs.com/CarpenterLee/p/5488070.html

queue和priorityqueue不允许插入null值

linkedlist可以插入null值

具体说是通过完全二叉树（complete binary tree）
实现的小顶堆（任意一个非叶子节点的权值，都不大于其左右子节点的权值），
也就意味着可以通过数组来作为PriorityQueue的底层实现。

堆是一棵被完全填满的二叉树，有可能的例外是在底层，底层上的元素从左到右填入。这样的树被称为完全二叉树（complete binary tree）

stack和queue现在很多都用arraydeque实现

| Queue Method | Equivalent Deque Method | 说明 |
|--------|--------|--------|
| `add(e)` | `addLast(e)` | 向队尾插入元素，失败则抛出异常 |
| `offer(e)` | `offerLast(e)` | 向队尾插入元素，失败则返回`false` |
| `remove()` | `removeFirst()` | 获取并删除队首元素，失败则抛出异常 |
| `poll()` | `pollFirst()` | 获取并删除队首元素，失败则返回`null` |
| `element()` | `getFirst()` | 获取但不删除队首元素，失败则抛出异常 |
| `peek()` | `peekFirst()` | 获取但不删除队首元素，失败则返回`null` |

下表列出了*Deque*与*Stack*对应的接口：

| Stack Method | Equivalent Deque Method | 说明 |
|--------|--------|--------|
| `push(e)` | `addFirst(e)` | 向栈顶插入元素，失败则抛出异常 |
| 无 | `offerFirst(e)` | 向栈顶插入元素，失败则返回`false` |
| `pop()` | `removeFirst()` | 获取并删除栈顶元素，失败则抛出异常 |
| 无 | `pollFirst()` | 获取并删除栈顶元素，失败则返回`null` |
| `peek()` | `peekFirst()` | 获取但不删除栈顶元素，失败则抛出异常 |
| 无 | `peekFirst()` | 获取但不删除栈顶元素，失败则返回`null` |

Queue<> q = new ArrayDeque<>() or Queue<> q = new LinkedList<>();

Deque<>  d= new ArrayDeque<>();
