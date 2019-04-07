public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        // Arrays.sort(A, (a,b)-> a.start- b.start);
        // Arrays.sort(B, (a,b)-> a.start- b.start);
        List<Interval> result = new ArrayList<>();
        int i=0; int j =0;
        while(i< A.length && j< B.length){
//             if(A[i].start > B[j].end){
//                 j++;
//             }else if(A[i].end < B[j].start){
//                 i++;
//             }else{
                int low = Math.max(A[i].start, B[j].start);
                int high = Math.min(A[i].end, B[j].end);
                result.add(new Interval(low, high));
                if(A[i].end < B[j].end){
                    i++;
                }else{
                    j++;
                }
            }
        }

        Interval[] res = new Interval[result.size()];
        for(int n=0; n< res.length; n++){
            res[n] = result.get(n);
        }
        return  res;
    }
