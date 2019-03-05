 //我的解法 O(n2)
 public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length  == 0){
            return 0;
        }
        int count =0;
        for(int i =0; i< nums.length; i++){
            int sum = nums[i];
            for(int j = i; j< nums.length; j++){
                if(j == i){
                    if(sum == k){
                        count++;
                    }
                }else{
                    sum += nums[j];
                    if(sum == k){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    
    //using prefixSum O(n2)
