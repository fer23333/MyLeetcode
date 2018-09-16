
//BFS
//
public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return result;
        queue.offer(root);
        
        while(!queue.isEmpty()){
            List<Integer> cur = new ArrayList<>();
            int size = queue.size();    
            for(int i = 0; i< size; i++){
                TreeNode head = queue.poll();
                cur.add(head.val);
                if(head.left !=null){
                    queue.offer(head.left);
                }
                if(head.right != null){
                    queue.offer(head.right);
                }
            }
            result.add(cur);   
        }
    return result;
    } 
