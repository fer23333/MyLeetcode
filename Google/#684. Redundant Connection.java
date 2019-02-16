说明 n个顶点 只需要n-1条边就可有一条全联通的图
去除二叉树的多余边 无向图
 !!!!!!!注意 
 List<Double> original = // some list
List<Double> copy = new ArrayList<Double>(original); //This does a shallow copy

https://blog.csdn.net/dm_vincent/article/details/7655764

Path compression involves changing the x = parent[x] in the find function to parent[x] = find(parent[x]). 
Basically, as we compute the correct leader for x, we should remember our calculation.

Union-by-rank involves distributing the workload of find across leaders evenly. 
  Whenever we dsu.union(x, y), we have two leaders xr, yr and we have to choose whether we want parent[x] = yr or parent[y] = xr. 
  We choose the leader that has a higher following to pick up a new follower.
Specifically, the meaning of rank is that there are less than 2 ^ rank[x] followers of x. 
  This strategy can be shown to give us better bounds for how long the recursive loop in dsu.find could run for.
