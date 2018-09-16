
// https://www.cnblogs.com/shunyu/p/4986288.html 二叉树遍历分析
// 根的意思是输出当前节点值
// preorder 比较简单直接

public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if(cur.right != null){
               stack.push(cur.right); 
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
        return res;
    }
// inorder 左 根 右
// 原则：访问左子树。【先访问左子树中的左子树，再访问左子树中的右子树。】直到访问到叶子结点

// 　　　　　　　输出根。

// 　　 访问右子树。【先访问右子树中的左子树，再访问右子树中的右子树。】直到访问到叶子结点

//  一直往左找到叶子节点输出 再右移一个 再往复
public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur!= null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        
        return res;
    }

// postorder
// 原则：访问左子树。【先访问左子树中的左子树，再访问左子树中的右子树】。直到访问到叶子结点

// 　　　访问右子树。【先访问右子树中的左子树，再访问右子树中的右子树】。直到访问到叶子结点

// 　　　	再返回访问根，并输出。
public List<Integer> postorderTraversal(TreeNode root) {
        //non-recursive;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> postorder = new ArrayList<Integer>();
        TreeNode node = root;
        TreeNode lastVisit = root;
        while(node != null || !stack.empty()){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.peek();//查看当前栈顶元素
            //如果其右子树也为空，或者右子树已经访问
            //则可以直接输出当前节点的值
            if(node.right == null || node.right == lastVisit){
                postorder.add(node.val);
                stack.pop();
                lastVisit = node;
                node = null;
            }else{//否则继续遍历右子树
                node  = node.right;
            }
        }
        return postorder;
    }

