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
