private final PriorityQueue<Integer> minHeap;
    private final int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for(int i : nums){
            minHeap.offer(i);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }    
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if(minHeap.size() > k ){
            minHeap.poll();
        }
        return minHeap.peek(); 
    }
