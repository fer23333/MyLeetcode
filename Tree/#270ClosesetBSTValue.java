设置 minDiff和res 如果接近了就更新
如果root的值大于target 向左走（小）
反之向右走
    private static Double minDiff;
    private static int result;
    public int closestValue(TreeNode root, double target) {
        // write your code here
        if(root == null){
            return -1;
        }
        minDiff = Double.MAX_VALUE;
        helper(root, target);
        return result;
    }
    public void helper(TreeNode root, double target){
        if(root == null){
            return;
        }
        if(Math.abs(root.val - target) < minDiff){
            result = root.val;
            minDiff = Math.abs(root.val - target);
        }
        if(root.val > target){
            helper(root.left, target);
        }else{
            helper(root.right,target);
        }
        
        
    }


//Iteration
    public int closestValue(TreeNode root, double target) {
        // write your code here
        if(root == null){
            return -1;
        }
        Double minDiff = Double.MAX_VALUE;
        int res = root.val;
        while(root != null){
            if(Math.abs(root.val - target) < minDiff){
                res= root.val;
                minDiff = Math.abs(root.val - target);
            }
            if(root.val > target){
                root = root.left;
            }else{
                root= root.right;
            }
        }
        return res;
    }
