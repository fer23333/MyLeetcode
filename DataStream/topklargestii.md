# 优先队列并不保证max min值以外值的序列!!!!
# maxheap 也可为 9 2 3

```
private PriorityQueue<Integer> pq;
private int k;

public Solution(int k) {
    // do intialization if necessary
    pq = new PriorityQueue<>();
    this.k = k;
}

public void add(int num) {
    pq.offer(num);
    while(pq.size() > k){
        pq.poll();
    }  
}


public List<Integer> topk() {
    // 新建一个list装入pq的值 在对他做sort后输出
    List<Integer> res = new ArrayList<>(pq);
    //也可以新建一个pq 再一个个poll 不影响之前的 
    // PriorityQueue<Integer> temp = new PriorityQueue<>(pq);
    // while(!temp.isEmpty()){
    //   res.add(temp.poll()); 
    // }
    // Collections.reverse(res);

    Collections.sort(res, Collections.reverseOrder());

    return res;
}
```
