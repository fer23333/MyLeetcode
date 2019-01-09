
由AOV网构造拓扑序列的拓扑排序算法主要是循环执行以下两步，直到不存在入度为0的顶点为止。
(1) 选择一个入度为0的顶点并输出之；
(2) 从网中删除此顶点及所有出边。
循环结束后，若输出的顶点数小于网中的顶点数，则输出“有回路”信息，否则输出的顶点序列就是一种拓扑序列

根据《算法概论》中对有向无环图（DAG）的讲解，判断一个有向图是否有环，有两个算法：

1. 拓扑排序
即找出该图的一个线性序列，使得需要事先完成的事件总排在之后才能完成的事件之前。如果能找到这样一个线性序列，则该图是一个有向无环图

2. DFS
遍历图中的所有点，从i点出发开始DFS，如果在DFS的不断深入过程中又回到了该点，则说明图中存在回路。
