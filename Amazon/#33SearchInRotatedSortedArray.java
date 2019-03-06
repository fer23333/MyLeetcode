//one pass 如果mid > left 说明左半部分单调递增 判定target是否在此区间
// 如果mid < left 说明右半部分单调递增 判定target是否在此区间 
//一定要使用闭区间 判定 target 是否在 两端时也相等, 否则会挑错区间
// 没有rotated的情况就是一直 mid < left
public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int left = 0; 
        int right = nums.length -1;
        while(left < right -1){
            int mid  = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > nums[left]){
                if(nums[mid] >= target && target >= nums[left]){
                    right = mid;
                }else{
                    left = mid;
                }
            }else{
                if(target <= nums[right] && target >= nums[mid] ){
                    left= mid;
                }else{
                    right = mid;
                }
            }
        }

        if(nums[left] == target){
            return left;
        }
        if(nums[right] == target){
            return right;
        }
        return -1;
    }
