1.没有 parent node   

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return root;
        }
        if(root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p ,q);
        if(left != null && right != null){
            return root;
        }
        return left != null ? left : right;
    }
    
2.有parent node

3.两个node可能在树上不存在

4.最后有可能的一个follow up：
如果是有k次查找，k也许会非常大，这样时间复杂度就是O(n*k) 复杂度太高 能不能优化呢？我自己的想法就是union find这样可以压缩路径，但是我忽略了压缩出来的路径也许并不是LCA的结果。然后网上搜索了一下，发现有一个神奇的Tarjan算法（是我孤陋寡闻了）：
离线LCA(Tarjan)算法 基于后续遍历的DFS + UnionFind


参考文档地址：https://segmentfault.com/a/1190000015145319
