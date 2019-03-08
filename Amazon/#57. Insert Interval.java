    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals == null || newInterval == null){
            return intervals;
        }    
        List<Interval> res = new ArrayList<>();
        int pos = 0;
        for(Interval interval : intervals){
            if(newInterval.end < interval.start){

                res.add(interval);
               
            }else if(newInterval.start > interval.end){

                 pos++;
                res.add(interval);
            }else{
                //overlapping
                newInterval.start = Math.min(newInterval.start , interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            }
        }
        res.add(pos, newInterval);
        return res;
        
    }
