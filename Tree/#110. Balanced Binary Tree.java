time O(n)

//104思路 使用flag
private boolean flag;
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        flag = true;
        int ans = maxDepth(root);
        
        return flag;
    }
    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }    
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        if(left - right > 1 || right - left > 1){
            flag = false;
        }
        return Math.max(left, right)  + 1;
    }
    
//类似方法 不使用全局变量
public boolean isBalanced(TreeNode root) {
        StringBuilder isBalance = new StringBuilder("");
        heightCheck(root, isBalance);
        return isBalance.length() == 0;
    }
    
    public int heightCheck(TreeNode root, StringBuilder isBalance) {
        if(root == null) {
            return 0;
        }
        
        int lh = heightCheck(root.left, isBalance);
        int rh = heightCheck(root.right, isBalance);
        if(Math.abs(lh - rh) > 1 && isBalance.length() == 0){
            isBalance.append("FALSE");
        }
        
        return Math.max(lh,rh) + 1;
    }
    
//
public boolean isBalanced(TreeNode root){
		if(root == null){
			return true;
		}
		return maxDepth(root) != -1;
}
public int maxDepth(TreeNode root){
	if(root == null){
		return 0;
	}
	int left=  maxDepth(root.left);
	int right = maxDepth(root.right);
	if(left == -1 || right == -1 || Math.abs(left - right) > 1){
		return -1;
	}
	return Math.max(left, right) + 1;

}
    
