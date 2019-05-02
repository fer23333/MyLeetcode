# Disjoint-set/ Union-Find Forest

https://zxi.mytechroad.com/blog/data-structure/sp1-union-find-set/

Find(x) : find the root/cluster -id of x

Union(x,y) : merge two clusters

*: amortized 表示 平均时间复杂度

check whether two elements are in the smae set or not in O(1)*

Without optimizatino: find O(n)

Qtwo key optimizations:
1. path compression : make tree flat
2. union by rank: merge low rank tree to high rank pne

```
class UnionFindSet {
  private int[] parents_;
  private int[] ranks_;
 
  public UnionFindSet(int n) {
      parents_ = new int[n + 1];
      ranks_ = new int[n + 1];
      for (int i = 0; i < parents_.length; ++i) {
          parents_[i] = i;
          ranks_[i] = 1;
      }
  }
 
  public boolean Union(int u, int v) {
      int pu = Find(u);
      int pv = Find(v);
      if (pu == pv) return false;
 
      if (ranks_[pv] > ranks_[pu])
          parents_[pu] = pv;           
      else if (ranks_[pu] > ranks_[pv])
          parents_[pv] = pu;
      else {
          parents_[pv] = pu;
          ranks_[pu] += 1;
      }
 
      return true;
  }
 
  public int Find(int u) {
      while (parents_[u] != u) {
          parents_[u] = parents_[parents_[u]];
          u = parents_[u];
      }
      return u;
  }
}
```
