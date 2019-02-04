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

//divide and conquer

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        for (String path : leftPaths) {
            paths.add(root.val + "->" + path);
        }
        for (String path : rightPaths) {
            paths.add(root.val + "->" + path);
        }
        
        // root is a leaf
        if (paths.size() == 0) {
            paths.add("" + root.val);
        }
        
        return paths;
    }
