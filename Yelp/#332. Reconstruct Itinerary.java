欧拉有向图， 欧拉路径
保证了存在一条路径而且给了start vertex 是简化版的问题

首先将adjancetlist 用map存， 犹豫题目要求先输出lexo order， 所以用priorityqueue做value
非递归写法： 用stack存遍历过的path， 当该点存在而且， 还有没访问过的下一个点

Thus the idea is to keep following unused edges and removing them until we get stuck. 
Once we get stuck, we back-track to the nearest vertex in our current path that has unused edges, 
and we repeat the process until all the edges have been used. We can use another container to maintain the final path.


 public List<String> findItinerary(List<List<String>> tickets) {
           //["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
        if(tickets == null || tickets.size() == 0){
            return new ArrayList<>();
        }
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        List<String> res= new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();
        for(List<String> s : tickets){
            if(!map.containsKey(s.get(0))){
                PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> a.compareTo(b));
                map.put(s.get(0), pq);
            }
            map.get(s.get(0)).add(s.get(1));
            System.out.println(map.get(s.get(0)));
        }
        stack.push("JFK");
        while(!stack.isEmpty()){
            while(map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty()){
                stack.push(map.get(stack.peek()).poll());
            }
            res.add(0,stack.pop());
            System.out.println(stack);
        }
        return res;
    }
    
    
