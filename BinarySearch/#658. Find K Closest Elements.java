public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr == null || arr.length == 0){
            return new ArrayList<>();
        }    
        int left = 0;
        int right = arr.length -k;
        //looking for left bound
        List<Integer> result = new ArrayList<>();
        while(left < right){
            int mid = left + (right - left) / 2;
            if(arr[mid] < x){
                if(x - arr[mid] > arr[mid+k] - x){
                    left = mid+1;
                }else{
                    right = mid;
                }
            }else{
                right = mid;
            }
        }
        int index = left;
        for(int i=index; i< index+k; i++){
            result.add(arr[i]);
        }
        return result;
        
        
    }
