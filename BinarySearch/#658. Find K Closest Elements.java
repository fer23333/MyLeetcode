//寻找最左的左bound o -> n-k
//0 ... mid...mid+k...n-k
//如果 x > a[mid], 左边界仍然可能在mid左边
// 如果a[mid+k] 比a[mid] 更接近 左边界最左一定在mid+1 的位置
//其他情况都是 right = mid

//不能用绝对值 因为 112222233, x=3,k=2 此时不满足

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
