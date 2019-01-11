queue和priorityqueue不允许插入null值

linkedlist可以插入null值

具体说是通过完全二叉树（complete binary tree）
实现的小顶堆（任意一个非叶子节点的权值，都不大于其左右子节点的权值），
也就意味着可以通过数组来作为PriorityQueue的底层实现。
