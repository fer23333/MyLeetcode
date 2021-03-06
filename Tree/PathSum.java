//双 pre  divide & conquer的思想
//如果输入的是一个空节点，则直接返回false，如果如果输入的只有一个根节点，则比较当前根节点的值和参数sum值是否相同，
//若相同，返回true，否则false。 这个条件也是递归的终止条件。
//下面我们就要开始递归了，由于函数的返回值是Ture/False，我们可以同时两个方向一起递归，中间用或||连接，
//只要有一个是True，整个结果就是True。递归左右节点时，这时候的sum值应该是原sum值减去当前节点的值。
 public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) 
            return false;
        if(root.left == null && root.right == null && root.val == sum)
            return true;
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum - root.val);
    }
