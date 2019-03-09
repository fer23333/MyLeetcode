  //priorityQueue minHeap + hashmap
  //O(nlogk)
  //需要clarify 需要topk个元素 还是topk词频的元素
  public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        } 
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
            (a,b) -> a.getValue() - b.getValue()
        );
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            heap.offer(entry);
            if(heap.size() > k){
                heap.poll();
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!heap.isEmpty()){
            Map.Entry<Integer, Integer> entry = heap.poll();
            result.add(0, entry.getKey());
        }
        return result;
        
    }
    
    //bucket sort O(n) bucket里面放数字 index表示频率
    
        public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        } 
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for(int key : map.keySet()){
            int freq = map.get(key);
            if (bucket[freq] == null) {
			    bucket[freq] = new ArrayList<>();
		    }
            bucket[freq].add(key);
        }
        List<Integer> result = new ArrayList<>();
        int i = nums.length;
        for(int pos = nums.length; pos >=0 && result.size() <k; pos--){
            if(bucket[pos] != null){
                result.addAll(bucket[pos]);
            }
        }
        
        return result;
    }
    
    //sort
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> candidates = new ArrayList(count.keySet());
        Collections.sort(candidates, (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                w1.compareTo(w2) : count.get(w2) - count.get(w1));

        return candidates.subList(0, k);
        }
