//两种形式  
public List<Integer> postorderTraversal(TreeNode root) {
            //traversal;
        List<Integer> result = new ArrayList<Integer>();
        traverse(result, root);
        return result;
    }    
    public void traverse (List<Integer> result, TreeNode root){
        if(root == null){
            return; 
        }
        traverse(result, root.left);
        traverse(result, root.right);
        result.add(root.val);
    }

  //1.一个和全局变量, 一个和子模块有关
 //2.从下往上走 会有层数相关
 public List<Integer> postorderTraversal(TreeNode root) {
        //divide & conquer;
        List<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        
        List<Integer> leftNode = postorderTraversal(root.left);
        List<Integer> rightNode = postorderTraversal(root.right);
        
        result.addAll(leftNode);
        result.addAll(rightNode);
        result.add(root.val);
        return result;
    }

//模板

//结果
public<T> helper(TreeNode root){
	if(root == null) return 0;
	<T> l = helper(root.left);
	<T> r = helper(root.right); // + 1
	//操作
    return 结果/(l,r);
}
