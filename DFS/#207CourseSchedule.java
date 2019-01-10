
由AOV网构造拓扑序列的拓扑排序算法主要是循环执行以下两步，直到不存在入度为0的顶点为止。
(1) 选择一个入度为0的顶点并输出之；
(2) 从网中删除此顶点及所有出边。
循环结束后，若输出的顶点数小于网中的顶点数，则输出“有回路”信息，否则输出的顶点序列就是一种拓扑序列

根据《算法概论》中对有向无环图（DAG）的讲解，判断一个有向图是否有环，有两个算法：

1. 拓扑排序
即找出该图的一个线性序列，使得需要事先完成的事件总排在之后才能完成的事件之前。如果能找到这样一个线性序列，则该图是一个有向无环图

2. DFS
遍历图中的所有点，从i点出发开始DFS，如果在DFS的不断深入过程中又回到了该点，则说明图中存在回路。

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0){
            return true;
        }
        int m = prerequisites.length; int n = prerequisites[0].length;
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        //注意map存的是 先序-》后序课程
        for(int[] pre : prerequisites){
            indegree[pre[0]]++;
            if(map.containsKey(pre[1])){
                map.get(pre[1]).add(pre[0]);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(pre[0]);
                map.put(pre[1], list);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        //queue保存入度为0的点并不断更新 
        //initialize
        for(int i=0; i< numCourses; i++){
            if(indegree[i] == 0)
                q.offer(i);
        }
        while(!q.isEmpty()){
            int number = q.poll();
            List<Integer> adj = map.get(number);
            System.out.println(adj);
            //由于邻接链表可能为空 而且bfs的范围是领结链表的size而不是q的size
            for(int i =0; adj!= null && i< adj.size(); i++){
                indegree[adj.get(i)]--;
                if(indegree[adj.get(i)] == 0 ){
                    q.offer(adj.get(i));
                }

            }
        }
        for(int i =0; i< numCourses; i++){
            if(indegree[i] != 0){
                return false;
            }
        }
        return true;
        
    }
    
使用领结表结构 ArrayList<Integer>[] G = new ArrayList[n];

    public boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<Integer>[] G = new ArrayList[n];
        int[] degree = new int[n];
        ArrayList<Integer> bfs = new ArrayList();
        for (int i = 0; i < n; ++i) G[i] = new ArrayList<Integer>();
        for (int[] e : prerequisites) {
            G[e[1]].add(e[0]);
            degree[e[0]]++;
        }
        for (int i = 0; i < n; ++i) if (degree[i] == 0) bfs.add(i);
        for (int i = 0; i < bfs.size(); ++i)
            for (int j: G[bfs.get(i)])
                if (--degree[j] == 0) bfs.add(j);
        return bfs.size() == n;
    }
