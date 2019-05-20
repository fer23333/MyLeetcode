//使用minheap
//时间: O(n)+ O(k) + O((n-k)*(logk)) + O(klogk) = O(n) + O(nlogk)
public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        List<Integer> res= new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){ 
            map.put(i, map.getOrDefault(i, 0) + 1);            
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(k, (a,b)-> a.getValue()- b.getValue());
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(entry);
            if(pq.size() > k){
                pq.poll();
            } 
        }
        while(!pq.isEmpty()){
            res.add(0,pq.poll().getKey());
        }
        return res;
    }
    
    //更简洁的写法
    public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        List<Integer> res= new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){ 
            map.put(i, map.getOrDefault(i, 0) + 1);            
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a,b)-> map.get(a) - map.get(b));
        for(int i : map.keySet()){
            pq.offer(i);
            if(pq.size() > k){
                pq.poll();
            }
        }
        while(!pq.isEmpty()){
            res.add(0,pq.poll());
        }
        return res;
    }
    
    //bucket sort
    //java 使用 泛型时 不能对array o
    
