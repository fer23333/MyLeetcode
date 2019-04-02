 public int depthSum(List<NestedInteger> nestedList) {
        // Write your code here
        if(nestedList == null || nestedList.size() == 0){
            return 0;
        }

        Queue<NestedInteger> queue = new LinkedList<NestedInteger>(nestedList);
        int sum = 0;
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            for(int i =0; i< size; i++){
                NestedInteger nest = queue.poll();
                if(nest.isInteger()){
                    sum+= level* nest.getInteger();
                }else{
                    for(NestedInteger n : nest.getList()){
                        queue.offer(n);
                    }
                }
            
            }
        }
        return sum;
    }
