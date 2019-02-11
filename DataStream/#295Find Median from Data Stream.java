存储一个maxheap和一个minheap

class MedianFinder {
   //two priority queue one for min heap, one for max heap
    private Queue<Integer> minHeap ;
    private Queue<Integer> maxHeap ;
    
    
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        // maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap = new PriorityQueue<Integer>( new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2){
                return i2 - i1;
            }
        });
        
    }
    //The max heap stores the smaller half of all numbers while the min heap stores the larger half. 
    // The sizes of two heaps need to be balanced each time when a new number is inserted
    // so that their size will not be different by more than 1
    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll()); //每次把最小数给 MaxHeap
        if(maxHeap.size() > minHeap.size()){ //保证size之差在［0，1］之间 minHeap size稍大一些
            minHeap.offer(maxHeap.poll());//每次把最大数给 minHeap
        }

    }
    
    public double findMedian() {
        if((maxHeap.size() + minHeap.size()) % 2 == 0 ){
            return (double)(maxHeap.peek() + minHeap.peek())/2;
        }else{
            return (double)minHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
