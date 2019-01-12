空的数组 new int[0]
设立一个visited指针
    
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //prereq: course->precourse
        //map: course->following courses list
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int[] pre  : prerequisites){
            indegree[pre[0]]++;
            if(map.containsKey(pre[1])){
                map.get(pre[1]).add(pre[0]);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(pre[0]);
                map.put(pre[1], list);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =0; i< numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int n =0;
        while(!q.isEmpty()){
            int number = q.poll();
            res[n++] = number;
            List<Integer> adj = map.get(number);
            for(int j =0; adj!= null && j< adj.size(); j++){
                indegree[adj.get(j)]--;
                if(indegree[adj.get(j)] == 0){
                    q.offer(adj.get(j));
                }
            }
        }

        if(n == numCourses){
            return res;
        }
        return new int[0]; 
    }
