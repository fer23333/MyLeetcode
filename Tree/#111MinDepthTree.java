    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(left == 0 || right == 0){
            return left+right+1;
        }
        return Math.min(left,right) + 1;
    }

//bfs
public int minDepth(TreeNode root) {
        if(root == null){
            return 0;    
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for(int i = 0; i< size; i++){
                TreeNode cur = queue.poll();
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
                if(cur.left == null && cur.right == null){
                    return depth;
                }
            }
        }
        return depth;
    }
