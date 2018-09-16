//双preorder 调用isSame
public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSame(root.left, root.right);
        
    }
    public boolean isSame(TreeNode p, TreeNode q){
        if(p== null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isSame(p.right,q.left ) && isSame(p.left, q.right );
    }
