找到kcloset value
可以存下中序遍历 然后在第k个数开始左右找
或者中序遍历的时候找符合的 
O(n), O(n)
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // write your code here
        if(root == null){
            return new LinkedList<>();
        }
        List<Integer> res = new LinkedList<>();
        dfs(root, target,res,k);
        return res;
    }
    public void dfs(TreeNode root, double target, List<Integer> res, int k){
        if(root == null){
            return;
        }
        dfs(root.left, target, res, k);
        if(res.size() < k){
            res.add(root.val);
        }else{
           if(Math.abs(root.val - target) < Math.abs(res.get(0) - target)){
            res.remove(0);
            res.add(root.val); 
            } 
        }
        dfs(root.right, target, res, k);

    }

最优算法，时间复杂度 O(k+logn)，空间复杂度 O(logn)
从指定节点开始分别向前和向后遍历，直到找到k个最接近target的节点。
使用prev和next两个栈分别记录前驱和后继，goPrev相当于反向中序遍历，goNext相当于正向中序遍历。

