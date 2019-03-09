//类似天上多少飞机的题 sort 
// checking how many meetings begin before the earliest-ended meeting ends.
//推荐写法 如果会议开始时 结束时间没到 就要加会议室, 如果会议开始时 结束时间已经过了 说明一个会议结束 可以使用这个会议室 count就不用再增加 
// 使用了 图论的扫描线算法
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
public int minMeetingRooms(Interval[] intervals) {
    if (intervals == null || intervals.length == 0)
        return 0;
        
    // Sort the intervals by start time
    Arrays.sort(intervals, new Comparator<Interval>() {
        public int compare(Interval a, Interval b) { return a.start - b.start; }
    });
    
    // Use a min heap to track the minimum end time of merged intervals
    PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
        public int compare(Interval a, Interval b) { return a.end - b.end; }
    });
    
    // start with the first meeting, put it to a meeting room
    heap.offer(intervals[0]);
    
    for (int i = 1; i < intervals.length; i++) {
        // get the meeting room that finishes earliest
        Interval interval = heap.poll();
        
        if (intervals[i].start >= interval.end) {
            // if the current meeting starts right after 
            // there's no need for a new room, merge the interval
            interval.end = intervals[i].end;
        } else {
            // otherwise, this meeting needs a new room
            heap.offer(intervals[i]);
        }
        
        // don't forget to put the meeting room back
        heap.offer(interval);
    }
    
    return heap.size();
}
