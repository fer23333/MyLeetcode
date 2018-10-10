
    public int sumNumbers(TreeNode root) {
        //preorder
        if(root == null) return 0;
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(root, res, sb);
        int sum =0;
        for(String s : res){
            sum += Integer.parseInt(s);
        }
        return sum;
    }
    public void helper(TreeNode root, List<String> res, StringBuilder sb){
        if(root == null) return;
        sb.append(root.val + "");
        if(root.left == null && root.right == null){
            res.add(sb.toString());
        }
        helper(root.left, res, sb);
        helper(root.right, res, sb);
        sb.deleteCharAt(sb.length() -1);
    }
