
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
// 原则：访问左子树。【先访问左子树中的左子树，再访问左子树中的右子树。】直到访问到叶子结点后输出。

// 　　　　　　　输出根。

// 　　 访问右子树。【先访问右子树中的左子树，再访问右子树中的右子树。】直到访问到叶子结点后输出。
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
// 原则：访问左子树。【先访问左子树中的左子树，再访问左子树中的右子树】。直到访问到叶子结点后输出。

// 　　　　　　  访问右子树。【先访问右子树中的左子树，再访问右子树中的右子树】。直到访问到叶子结点后输出。

// 　　　	再返回访问根，并输出。

