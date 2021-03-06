//利用max depth 
//This solution updates the max variable whenever the sum of left subtree and right subtree 
//is greater than the previous max sum. The return statement only keep track of the height of a node. 
//For every node, length of longest path which pass it = MaxDepth of its left subtree + MaxDepth of its right subtree.

    private int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        maxDepth(root);
        return max;
    }
    public int maxDepth(TreeNode root){
       if(root == null) return 0;
        int leftmax = maxDepth(root.left);
        int rightmax = maxDepth(root.right);
        max = Math.max(max, leftmax + rightmax);
        return Math.max(leftmax , rightmax) + 1;
    }
