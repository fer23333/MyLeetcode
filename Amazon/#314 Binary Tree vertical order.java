   public List<List<Integer>> verticalOrder(TreeNode root) {
        // write your code here
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();
        Map<Integer, List<Integer>> map  = new HashMap<>();
        int min  = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        q.offer(root);
        col.offer(0);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode cur = q.poll();
                int column = col.poll();
                min = Math.min(min, column);
                max = Math.max(max, column);
                if(!map.containsKey(column)){
                    map.put(column, new ArrayList<>());
                }
                map.get(column).add(cur.val);
                if(cur.left != null){
                    q.offer(cur.left);
                    col.offer(column-1);
                }
                if(cur.right !=null){
                    q.offer(cur.right);
                    col.offer(column+1);
                }
            }
        }
        for(int i= min; i<= max; i++){
            result.add(map.get(i));
        }
        return result;
    }
