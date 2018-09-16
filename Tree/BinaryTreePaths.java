//从头往下 preorder
 
public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        String n = root.val + "";
        helper(root, result, n);
        return result;
    }
    public void helper(TreeNode root, List<String> result, String n){
        if(root == null) return;
        
      if(root.left == null && root.right == null)
            result.add(n);
      //操作 & 出口
      
        if(root.left != null)
            helper(root.left, result, n+"->" + root.left.val);
        if(root.right != null)
            helper(root.right, result, n+"->" + root.right.val);
        
    }
