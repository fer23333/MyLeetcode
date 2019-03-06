  //O(logn)
  public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int left = 0;
        int right =nums.length -1;
        while(left < right -1){
            int mid = left + (right -left)/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            }else if(nums[mid] < nums[mid+1] && nums[mid] > nums[mid-1]{
                left = mid;
            }else{
                right = mid;
            }
        }
        return nums[left] >= nums[right] ? left: right;
    }
