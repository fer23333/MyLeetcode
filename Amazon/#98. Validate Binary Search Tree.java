//BST 性质 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值
//由于表示正无穷 负无穷 在这里只能用 long_min, long_max 假如 treeNode 为long就没办法了
//所以使用integer 用指针来表示
//time O(n), space O(h)
// node.left < node < node.right 并不能保证 因为下面子节点值 也要对parent有保证 比如右边所有一定比root大 左边所有都比root小


public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        return helper(root, null, null);
    }
    public boolean helper(TreeNode root, Integer min, Integer max){
        if(root == null){
            return true;
        }
        if(min != null && root.val <= min){
            return false;
        }
        if(max != null && root.val >= max){
            return false;
        }
            
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
    
 //inorder traversal
 public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(prev != null && prev.val >= cur.val){
                return false;
            }
            prev = cur;
            cur = cur.right;
            
        }
        return true;
        
    }
