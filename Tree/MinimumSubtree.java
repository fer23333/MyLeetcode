Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.

这一类的题目都可以这样做：
开一个ResultType的变量result，来储存拥有最小sum的那个node的信息。
然后用分治法来遍历整棵树。
一个小弟找左子数的sum，一个小弟找右子树的sum。
同时，我们根据算出来的当前树的sum决定要不要更新result。
当遍历完整棵树的时候，result里记录的就是拥有最小sum的子树的信息

class ResultType{
    TreeNode node;
    int sum;
    public ResultType(TreeNode node, int sum){
        this.node = node;
        this.sum = sum;  
    }
}
public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    private ResultType result = null;
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        if(root == null){
            return root;
        }
        ResultType curResult= helper(root);
        return result.node;
    }
    public ResultType helper(TreeNode root){
        if(root == null){
            return new ResultType(root,0);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        ResultType cur = new ResultType(root,left.sum + right.sum+root.val);
        if(result == null || cur.sum < result.sum){
            result = cur;
        }
        return cur;
        
    }
}
