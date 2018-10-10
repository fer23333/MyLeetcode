
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

//改进 
    int total;
    
    public int sumNumbers(TreeNode root) {
        total = 0;
        helper(root, 0);
        return total;
    }
    
    void helper(TreeNode root, int sum) {
        if (root == null) return;
        
        sum = sum * 10 + root.val;
        
        if (root.left == null && root.right == null) {
            total += sum;
            return;
        }
        
        helper(root.left, sum);
        helper(root.right, sum);
    }
//去除全局变量
public int sumNumbers(TreeNode root) {
	return sum(root, 0);
}

public int sum(TreeNode n, int s){
	if (n == null) return 0;
	if (n.right == null && n.left == null) return s*10 + n.val;
	return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
}
