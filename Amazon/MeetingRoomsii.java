//类似天上多少飞机的题 sort 
// checking how many meetings begin before the earliest-ended meeting ends.
//推荐写法 如果会议开始时 结束时间没到 就要加会议室, 如果会议开始时 结束时间已经过了 说明一个会议结束 可以使用这个会议室 count就不用再增加 
//
//  start  | |    |  |
 //  end        |   |  | |
    public int minMeetingRooms(Interval[] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i =0; i<intervals.length; i++){
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int num =0;
        for(int i=0,j=0; i<start.length;i++){
            if(start[i] < end[j]){
                num++;
            }else{
                j++;    
            }
        }
        return num;
    }
//priorityqueue
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        if(intervals == null || intervals.size() == 0){
            return 0;
        }
        Collections.sort(intervals, (a,b)-> a.start - b.start);
        PriorityQueue<Interval> heap = new PriorityQueue<>((a,b)-> a.end - b.end);
        heap.offer(intervals.get(0));
        for(int i =1; i<intervals.size(); i++){
            Interval prev = heap.poll();
            Interval cur = intervals.get(i);
            if(cur.start >= prev.end){
                prev.end = cur.end;
            }else{
                heap.offer(cur);
            }
            heap.offer(prev);
            
        }
        return heap.size();
    }
