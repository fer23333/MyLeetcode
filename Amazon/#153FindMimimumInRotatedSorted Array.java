    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        } 
        int n = nums.length; 
        int left = 0;
        int right = n-1;
        while(left < right - 1){
            int mid = left + (right - left)/2;
            if(nums[mid] < nums[mid+1] && nums[mid] < nums[mid-1]){
                return nums[mid];
            }else if(nums[mid] > nums[n-1]){
                left = mid;
            }else if(nums[mid] < nums[n-1]){
                right = mid;
            }
        }
        return Math.min(nums[left],nums[right]);
    }
