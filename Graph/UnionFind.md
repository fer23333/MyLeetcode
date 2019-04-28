# Disjoint-set/ Union-Find Forest

Find(x) : find the root/cluster -id of x

Union(x,y) : merge two clusters

*: amortized 表示 平均时间复杂度

check whether two elements are in the smae set or not in O(1)*

Without optimizatino: find O(n)

Qtwo key optimizations:
1. path compression : make tree flat
2. union by rank: merge low rank tree to high rank pne

