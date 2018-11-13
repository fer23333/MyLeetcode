//https://articles.leetcode.com/construct-binary-tree-from-inorder-and-preorder-postorder-traversal/
    
 public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(0,0, inorder.length -1, preorder, inorder);
    }
    public TreeNode dfs(int preStart, int inStart,int inEnd, int[] preorder, int[] inorder ){
        if(preStart > preorder.length || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = 0;
        for(int i =inStart; i<= inEnd; i++){
           if(root.val == inorder[i]){
               index = i;
           } 
        }
        root.left =  dfs(preStart+1, inStart, index- 1, preorder, inorder);
        root.right = dfs(preStart+ index- inStart +1, index+1, inEnd, preorder, inorder); 
        return root;
    }
    
    //优化 可以加一个hashmap优化额外空间
    //Given a random balanced tree, time: O(N*logN) space: O(logN). 
    //The way you analyze it should be the same as mergesort.
    //There are logN layers, each layer costs N time. Hope it helps. A hashmap can improve this with extra memory.
