// postorder
//traversal    
public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        helper(root);
        return root;
    }
    public void helper(TreeNode root){
        if(root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left != null)
            helper(root.left);
        if(root.right != null)
            helper(root.right);
    }
//divide and conquer
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left =right;
        return root;
    }

//level order 不需要size控制的bfs
public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            if(cur.left != null)
                q.offer(cur.left);
            if(cur.right != null)
                q.offer(cur.right);
            
        }
        return root;
    }
