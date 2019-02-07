//和meeting room 类似 使用 扫描线算法
//O(n2) O(n) 由于pq.remove() 需要使用o（n）时间 优化可以使用 treemap
//也可以使用线段树


//使用maxheap
//首先对横坐标ascending排序 然后使用pq对纵坐标做筛选
//左重合降序 右重合升序
//起始点 最高点 / 终止点 第二高点

//起始点做负数 终止点做正数 如果点横坐标相同 起始点在前 终止点在后


    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if(buildings == null || buildings.length == 0 ){
            return res;    
        }  
        List<int[]> buildingPoints = new ArrayList<>();
        for(int[] b : buildings){
            buildingPoints.add(new int[]{b[0],-b[2]});
            buildingPoints.add(new int[]{b[1], b[2]});
        }
        Collections.sort(buildingPoints, (a,b)->{
            if(a[0] != b[0]){
                return a[0]- b[0];
            }else{
                return a[1]- b[1];
            }    
        });
        //Collections.sort(buildingPoints, (a,b)-> (a[0] == b[0]) ? a[1]-b[1] : a[0]- b[0]);
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b-a );
        //Queue<Integer> maxHeap = new PriorityQueue<>(Colletions.reverseOrder() );
        maxHeap.offer(0);//防止中间为0的点 由于输入是不包含0的 就不包含这个点了
        int preMax = 0;
        for(int[] bp : buildingPoints){
            if(bp[1] < 0){
                maxHeap.offer(-bp[1]);
                //由于是负数 放回去时要加负号
            }else{
                maxHeap.remove(bp[1]);
            }
            int curHeight = maxHeap.peek();
            if(curHeight != preMax){
                res.add(new int[]{bp[0],curHeight});
                preMax = curHeight;
            }
        }
        return res;
                      
    }
