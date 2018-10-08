// all path sum == target

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return  res;
        helper(root, res, new ArrayList<>(), sum);
        return res;
        
    }
    public void helper(TreeNode root, List<List<Integer>> res, List<Integer> subset, int sum){
        if(root == null) {
            return; 
        }
        subset.add(root.val);
        if(root.left == null && root.right == null && sum == root.val){
            res.add(new ArrayList<>(subset)); 
        }else{
            helper(root.left, res, subset, sum - root.val);
            helper(root.right, res, subset, sum - root.val);
          //到达底部自动会移除并return
        } 
        subset.remove(subset.size() - 1);

        
    }
