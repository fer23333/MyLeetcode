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

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<TreeNode> next = new Stack<TreeNode>();
        Stack<TreeNode> prev = new Stack<TreeNode>();
        TreeNode node = root;
        
        // find the nodes closest to target
        while (node != null) {
            if (node.val < target) {
                prev.push(node);
                node = node.right;
            } else {
                next.push(node);
                node = node.left;
            }
        }
        
        List<Integer> ret = new LinkedList<Integer>();
        
        while (ret.size() < k) {
            double distp = prev.isEmpty() ? Integer.MAX_VALUE : Math.abs(prev.peek().val - target);
            double distn = next.isEmpty() ? Integer.MAX_VALUE : Math.abs(next.peek().val - target);
            
            // compare and find the closest node, and move the corresponding stack.
            if (distp < distn) {
                ret.add(0, prev.peek().val);
                goPrev(prev);
            } else {
                ret.add(next.peek().val);
                goNext(next);
            }
        }
        
        return ret;
    }
    
    private void goNext(Stack<TreeNode> st) {
        TreeNode r = st.pop().right;
        
        while (r != null) {
            st.push(r);
            r = r.left;
        }
    }
    
    private void goPrev(Stack<TreeNode> st) {
        TreeNode l = st.pop().left;
        
        while (l != null) {
            st.push(l);
            l = l.right;
        }
    }
