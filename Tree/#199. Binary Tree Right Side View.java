//bfs
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){
            int size = q.size();
            for(int i= 0; i< size ;i++){
                TreeNode cur = q.poll();
                if(i == size-1){
                    result.add(cur.val);
                }
                if(cur.left != null){
                    q.offer(cur.left);    
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
            }
        }
        return result;
    }
    
 //dfs
 public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        
        List<Integer> result = new ArrayList<>();
        dfs(root, result, 0);
        return result;
    }
    public void dfs(TreeNode root, List<Integer> result, int depth){
        if(root == null){
            return;
        }
        if(result.size() == depth){
            result.add(root.val);
        }
        
        dfs(root.right, result, depth + 1);
        dfs(root.left, result, depth + 1);
    }
