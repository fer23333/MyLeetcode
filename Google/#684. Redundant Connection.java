说明 n个顶点 只需要n-1条边就可有一条全联通的图
去除二叉树的多余边 无向图
 !!!!!!!注意 
 List<Double> original = // some list
List<Double> copy = new ArrayList<Double>(original); //This does a shallow copy

https://blog.csdn.net/dm_vincent/article/details/7655764

Path compression involves changing the x = parent[x] in the find function to parent[x] = find(parent[x]). 
Basically, as we compute the correct leader for x, we should remember our calculation.
 O(1)
    public int find(int x){
        if(parent[x] == x){
           return x;
        } 
        parent[x] = find(parent[x]);
        return parent[x];
    }
Union-by-rank involves distributing the workload of find across leaders evenly. 
The above operations can be optimized to O(Log n) in worst case. 
The idea is to always attach smaller depth tree under the root of the deeper tree.
   //若不采用union by rank 复杂度O(n)
 public void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa != pb){
            parent[pb] = pa;
        }    
    }

//code
class UnionFind{
    private int[] parent;
    public UnionFind(int n){
        parent = new int[n+1];
        for(int i=1 ;i <= n; i++ ){
            parent[i]= i;
        }
    }
    public void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa != pb){
            parent[pb] = pa;
        }
        
    }
    public int find(int x){
        if(parent[x] == x){
           return x;
        } 
        parent[x] = find(parent[x]);
        return parent[x];
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);
        int[] res= new int[2];
        for(int[] edge : edges){
            if(uf.find(edge[0]) == uf.find(edge[1])){
                res[0] = edge[0];
                res[1] = edge[1];
                break;
            }else{
                uf.union(edge[0], edge[1]);
            }
        }
        return res;
    }
}


//采用优化后的 union
    public boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa == pb){
            return false;
        }else if(rank[pa] > rank[pb]){
            parent[pa] = pb;
        }else if(rank[pa] < rank[pb]){
            parent[pb] = pa;
        }else{
           parent[pa] = pb;
            rank[pb]++;
        }
        return true;
    }
