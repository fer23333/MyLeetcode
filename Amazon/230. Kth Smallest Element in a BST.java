 public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return 0;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(--k == 0){
                return cur.val;
            }
            cur =cur.right;
        }
        return -1;
    }
