Non-recursively
teim O(n), space O(1)
public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        while(root != null){
            if(root.left != null){
                TreeNode prev = root.left;
                while(prev.right!=null){
                    prev = prev.right;
                }
                prev.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
            
    }
