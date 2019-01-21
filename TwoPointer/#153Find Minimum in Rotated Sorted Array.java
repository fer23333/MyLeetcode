Input: [3,4,5,1,2] 
Output: 1

    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int n = nums.length;
        if(nums[0] < nums[n-1]){
            return nums[0];
        }
        int left = 0; int right = n-1;
        while(left < right-1){
            int mid = left + (right - left)/2;
            if(nums[mid]< nums[mid -1] && nums[mid]< nums[mid+1]){
                return nums[mid];
            }
            else if(nums[mid] > nums[right]){
                left =mid;
            }else if(nums[mid] < nums[right]){
                right = mid;
            }
        }
        if(nums[left] < nums[right]){
            return nums[left];
        }else return nums[right];
    }
